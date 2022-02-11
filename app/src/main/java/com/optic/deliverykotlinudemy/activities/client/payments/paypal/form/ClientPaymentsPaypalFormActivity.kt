package com.optic.deliverykotlinudemy.activities.client.payments.paypal.form

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.optic.deliverykotlinudemy.R
import com.optic.deliverykotlinudemy.activities.client.payments.paypal.status.ClientPaymentsPaypalStatusActivity
import com.optic.deliverykotlinudemy.adapters.ShoppingBagAdapter
import com.optic.deliverykotlinudemy.models.Address
import com.optic.deliverykotlinudemy.models.Product
import com.optic.deliverykotlinudemy.models.ResponseHttp
import com.optic.deliverykotlinudemy.models.User
import com.optic.deliverykotlinudemy.providers.CurrencyProvider
import com.optic.deliverykotlinudemy.providers.OrdersProvider
import com.optic.deliverykotlinudemy.utils.SharedPref
import com.paypal.checkout.approve.OnApprove
import com.paypal.checkout.cancel.OnCancel
import com.paypal.checkout.createorder.CreateOrder
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.OrderIntent
import com.paypal.checkout.createorder.UserAction
import com.paypal.checkout.error.OnError
import com.paypal.checkout.order.Amount
import com.paypal.checkout.order.AppContext
import com.paypal.checkout.order.Order
import com.paypal.checkout.order.PurchaseUnit
import com.paypal.checkout.paymentbutton.PayPalButton
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigDecimal
import java.math.RoundingMode

class ClientPaymentsPaypalFormActivity : AppCompatActivity() {

    val TAG = "ClientPaypalForm"
    var textViewAmount: TextView? = null
    var textViewUsd: TextView? = null
    var toolbar: Toolbar? = null
    var paypalButton: PayPalButton? = null
    var ordersProvider: OrdersProvider? = null
    var user: User? = null
    var sharedPref: SharedPref? = null
    var gson = Gson()
    var selectedProducts = ArrayList<Product>()
    var address: Address? = null

    var currencyProvider = CurrencyProvider()
    var total = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_payments_paypal_form)

        sharedPref = SharedPref(this)
        getUserFromSession()
        getAddressFromSession()
        ordersProvider = OrdersProvider(user?.sessionToken!!)

        toolbar = findViewById(R.id.toolbar)
        textViewAmount = findViewById(R.id.textview_amount)
        textViewUsd = findViewById(R.id.textview_usd)
        paypalButton = findViewById(R.id.payPalButton)

        getProductsFromSharedPref()

        toolbar?.setTitleTextColor(ContextCompat.getColor(this, R.color.black))
        toolbar?.title = "Procesar pago"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getCurrencyValue()

    }
    private fun createPaypalPayment(totalUSD: Double) {
        paypalButton?.setup(
            createOrder =
            CreateOrder { createOrderActions ->
                val order =
                    Order(
                        intent = OrderIntent.CAPTURE,
                        appContext = AppContext(userAction = UserAction.PAY_NOW),
                        purchaseUnitList =
                        listOf(
                            PurchaseUnit(
                                amount =
                                Amount(currencyCode = CurrencyCode.USD, value = "$totalUSD")
                            )
                        )
                    )
                createOrderActions.create(order)
            },
            onApprove =
            OnApprove { approval ->
                approval.orderActions.capture { captureOrderResult ->

                    if (captureOrderResult.toString().contains("Success")) {
                        createOrder()
                        Toast.makeText(this@ClientPaymentsPaypalFormActivity, "Pago Aprovado", Toast.LENGTH_LONG).show()
                    }
                    Log.i("CaptureOrder", "CaptureOrderResult: $captureOrderResult")
                }
            },
            onCancel = OnCancel {
                Log.d("OnCancel", "Buyer canceled the PayPal experience.")
            },
            onError = OnError { errorInfo ->
                Log.d("OnError", "Error: $errorInfo")
            }

        )
    }



    private fun goToPaypalStatus() {
        val i = Intent(this, ClientPaymentsPaypalStatusActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    private fun getCurrencyValue() {
        currencyProvider.getCurrencyValue()?.enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                if (response.body() != null) {
                    var usd = response.body()?.get("USD_PEN")?.asDouble

                    if (usd != null) {
                        var totalUsd = BigDecimal(total / usd).setScale(2, RoundingMode.HALF_EVEN)
                        createPaypalPayment(totalUsd.toDouble())
                        textViewUsd?.text = "${totalUsd}$"
                    }

                }

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(this@ClientPaymentsPaypalFormActivity, "Error: ${t.message}", Toast.LENGTH_LONG)
                    .show()
            }

        })
    }


    private fun createOrder() {

        val order = com.optic.deliverykotlinudemy.models.Order(
            products = selectedProducts,
            idClient = user?.id!!,
            idAddress = address?.id!!
        )

        ordersProvider?.create(order)?.enqueue(object: Callback<ResponseHttp> {
            override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>) {

                if (response.body() != null) {

                    if (response.body()?.isSuccess == true) {
                        sharedPref?.remove("order")
                        goToPaypalStatus()
                    }

                    Toast.makeText(this@ClientPaymentsPaypalFormActivity, "${response.body()?.message}", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this@ClientPaymentsPaypalFormActivity, "Ocurrio un error en la peticion", Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                Toast.makeText(this@ClientPaymentsPaypalFormActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun getUserFromSession() {

        val gson = Gson()

        if (!sharedPref?.getData("user").isNullOrBlank()) {
            // SI EL USARIO EXISTE EN SESION
            user = gson.fromJson(sharedPref?.getData("user"), User::class.java)
        }

    }


    private fun getProductsFromSharedPref() {

        if (!sharedPref?.getData("order").isNullOrBlank()) { // EXISTE UNA ORDEN EN SHARED PREF
            val type = object: TypeToken<ArrayList<Product>>() {}.type
            selectedProducts = gson.fromJson(sharedPref?.getData("order"), type)


            for (p in selectedProducts) {
                total = total + (p.price * p.quantity!!)
            }

            textViewAmount?.text = "${total} Soles"
        }

    }

    private fun getAddressFromSession() {

        if (!sharedPref?.getData("address").isNullOrBlank()) {
            address = gson.fromJson(sharedPref?.getData("address"), Address::class.java) // SI EXISTE

        }
        else {
            Toast.makeText(this, "Selecciona una direccion para continuar", Toast.LENGTH_LONG).show()
        }

    }
}