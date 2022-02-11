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

    @GET("convert?q="YOUR_API_KEY_FROM_CURRENCY_CONVERTER_API
         ")
    fun getCurrencyValue(): Call<JsonObject>


}
