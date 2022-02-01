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

    @GET("v1/payment_methods/installments?access_token=TEST-6028900970379574-062302-e3e5d11b7871ee742832e6351694608f-191014229")
    fun getInstallments(@Query("bin") bin: String, @Query("amount") amount: String): Call<JsonArray>

    @POST("v1/card_tokens?public_key=TEST-98db4d5d-663a-453b-858e-f66dfd623666")
    fun createCardToken(@Body body: MercadoPagoCardTokenBody): Call<JsonObject>
}