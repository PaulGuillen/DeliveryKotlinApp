package com.optic.deliverykotlinudemy.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") var name: String ? = null,
    @SerializedName("lastname") var lastname: String ? = null,
    @SerializedName("email") val email: String ? = null,
    @SerializedName("phone") var phone: String ? = null,
    @SerializedName("password") val password: String? = null ,
    @SerializedName("image") var image: String? = null,
    @SerializedName("session_token") val sessionToken: String? = null,
    @SerializedName("notification_token") var notificationToken: String? = null,
    @SerializedName("is_available") val isAvailable: Boolean? = null,
    @SerializedName("roles") val roles: ArrayList<Rol>? = null
) {

    override fun toString(): String {
        return "$name $lastname"
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}