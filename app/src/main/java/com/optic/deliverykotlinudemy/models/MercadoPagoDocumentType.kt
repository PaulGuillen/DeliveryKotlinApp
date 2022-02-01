package com.optic.deliverykotlinudemy.models
import com.google.gson.annotations.SerializedName

class MercadoPagoDocumentType(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("min_length") val minLength: Int,
    @SerializedName("max_length") val maxLength: Int,

    ) {

    override fun toString(): String {
        return name
    }
}