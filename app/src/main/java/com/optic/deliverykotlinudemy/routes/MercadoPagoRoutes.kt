package com.optic.deliverykotlinudemy.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.optic.deliverykotlinudemy.models.MercadoPagoCardTokenBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MercadoPagoRoutes {

    @GET("v1/payment_methods/installments?access_token="YOUR_FIRST_API_KEY_FROM_MERCADOPEGADO")
    fun getInstallments(@Query("bin") bin: String, @Query("amount") amount: String): Call<JsonArray>

    @POST("v1/card_tokens?public_key="YOUR_SECOND_API_KEY_FROM_MERCADO_PAGO")
    fun createCardToken(@Body body: MercadoPagoCardTokenBody): Call<JsonObject>
}
