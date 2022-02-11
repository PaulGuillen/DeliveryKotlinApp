package com.optic.deliverykotlinudemy.activities.client.payments.payment_method

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.optic.deliverykotlinudemy.R
import com.optic.deliverykotlinudemy.activities.client.payments.mercadopago.form.ClientPaymentFormActivity
import com.optic.deliverykotlinudemy.activities.client.payments.paypal.form.ClientPaymentsPaypalFormActivity

class ClientPaymentMethodActivity : AppCompatActivity() {

    var imageViewMercadoPago: ImageView? = null
    var imageViewPaypal: ImageView? = null
    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_payment_method)

        imageViewMercadoPago = findViewById(R.id.imageview_mercadopago)
        imageViewPaypal = findViewById(R.id.imageview_paypal)
        toolbar = findViewById(R.id.toolbar)

        toolbar?.setTitleTextColor(ContextCompat.getColor(this, R.color.black))
        toolbar?.title = "Métodos de pago"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageViewMercadoPago?.setOnClickListener { goToMercadoPago() }
        imageViewPaypal?.setOnClickListener { goToPaypal() }

    }

    private fun goToMercadoPago(){
        val i = Intent(this, ClientPaymentFormActivity::class.java)
        startActivity(i)
    }

    private fun goToPaypal(){
        val i = Intent(this, ClientPaymentsPaypalFormActivity::class.java)
        startActivity(i)
    }
}