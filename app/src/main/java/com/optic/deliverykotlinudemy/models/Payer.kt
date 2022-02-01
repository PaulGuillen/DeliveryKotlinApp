package com.optic.deliverykotlinudemy.models
import com.google.gson.annotations.SerializedName

class Payer(
    @SerializedName("email") val email: String,
    ) {

    override fun toString(): String {
        return "Payer(email='$email')"
    }
}