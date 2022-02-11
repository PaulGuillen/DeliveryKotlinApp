package com.optic.deliverykotlinudemy.providers

import android.util.Log
import com.optic.deliverykotlinudemy.api.ApiRoutes
import com.optic.deliverykotlinudemy.models.Category
import com.optic.deliverykotlinudemy.models.MercadoPagoPayment
import com.optic.deliverykotlinudemy.models.ResponseHttp
import com.optic.deliverykotlinudemy.models.User
import com.optic.deliverykotlinudemy.routes.CategoriesRoutes
import com.optic.deliverykotlinudemy.routes.PaymentsRoutes
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import java.io.File

class PaymentsProvider(val token: String) {

    private var paymentsRoutes: PaymentsRoutes? = null

    init {
        val api = ApiRoutes()
        paymentsRoutes = api.getPaymentsRoutes(token)
    }

    fun create(mercadoPagoPayment: MercadoPagoPayment): Call<ResponseHttp>? {
        return paymentsRoutes?.createPayment(mercadoPagoPayment, token)
    }

}