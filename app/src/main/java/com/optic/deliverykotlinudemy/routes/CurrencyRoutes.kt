package com.optic.deliverykotlinudemy.routes


import com.google.gson.JsonObject
import com.optic.deliverykotlinudemy.models.Address
import com.optic.deliverykotlinudemy.models.Category
import com.optic.deliverykotlinudemy.models.ResponseHttp
import com.optic.deliverykotlinudemy.models.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface CurrencyRoutes {

    @GET("convert?q=USD_PEN&compact=ultra&apiKey=766a054691a396ff9c79")
    fun getCurrencyValue(): Call<JsonObject>


}