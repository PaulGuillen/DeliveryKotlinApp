package com.optic.deliverykotlinudemy.models

import com.google.gson.Gson

class Category(
    val id: String? = null,
    val name: String,
    val image: String? = null,
) {

    override fun toString(): String {
        return name
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}