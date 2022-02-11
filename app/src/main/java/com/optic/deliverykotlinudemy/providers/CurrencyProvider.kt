package com.optic.deliverykotlinudemy.providers

import android.util.Log
import com.google.gson.JsonObject
import com.optic.deliverykotlinudemy.api.ApiRoutes
import com.optic.deliverykotlinudemy.api.CurrencyApiRoutes
import com.optic.deliverykotlinudemy.models.Address
import com.optic.deliverykotlinudemy.models.Category
import com.optic.deliverykotlinudemy.models.ResponseHttp
import com.optic.deliverykotlinudemy.models.User
import com.optic.deliverykotlinudemy.routes.AddressRoutes
import com.optic.deliverykotlinudemy.routes.CategoriesRoutes
import com.optic.deliverykotlinudemy.routes.CurrencyRoutes
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import java.io.File

class CurrencyProvider() {

    private var currencyRoutes: CurrencyRoutes? = null

    init {
        val api = CurrencyApiRoutes()
        currencyRoutes = api.getCurrencyRoutes()
    }

    fun getCurrencyValue(): Call<JsonObject>? {
        return currencyRoutes?.getCurrencyValue()
    }


}