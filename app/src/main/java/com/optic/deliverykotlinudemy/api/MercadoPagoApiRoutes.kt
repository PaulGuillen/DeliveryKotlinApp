package com.optic.deliverykotlinudemy.api

import com.optic.deliverykotlinudemy.routes.*
import retrofit2.Retrofit

class MercadoPagoApiRoutes {

    val API_URL = "https://api.mercadopago.com/"
    val retrofit = RetrofitClient()

    fun getMercadoPagoRoutes(): MercadoPagoRoutes {
        return retrofit.getClient(API_URL).create(MercadoPagoRoutes::class.java)
    }

}