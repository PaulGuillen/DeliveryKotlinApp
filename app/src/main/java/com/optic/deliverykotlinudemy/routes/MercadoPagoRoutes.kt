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

    @GET("v1/payment_methods/installments?access_token=TEST-4659571356318640-020116-69ac61dc680956253853fe7e4fe86ba7-666034814")
    fun getInstallments(@Query("bin") bin: String, @Query("amount") amount: String): Call<JsonArray>

    @POST("v1/card_tokens?public_key=TEST-40a80dbc-df47-45ba-8951-5f197c7199c0")
    fun createCardToken(@Body body: MercadoPagoCardTokenBody): Call<JsonObject>
}