package com.optic.deliverykotlinudemy.models

import com.google.gson.Gson

class SocketEmit(
    val id_order: String,
    val lat: Double,
    val lng: Double,
) {

    override fun toString(): String {
        return "SocketEmit(id_order='$id_order', lat=$lat, lng=$lng)"
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}