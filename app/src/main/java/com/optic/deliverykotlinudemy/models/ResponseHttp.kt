package com.optic.deliverykotlinudemy.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class ResponseHttp(
    @SerializedName("message") val message: String,
    @SerializedName("success") val isSuccess: Boolean,
    @SerializedName("data") val data: JsonObject,
    @SerializedName("error") val error: String,
) {

    override fun toString(): String {
        return "ResponseHttp(message='$message', isSuccess=$isSuccess, data=$data, error='$error')"
    }
}