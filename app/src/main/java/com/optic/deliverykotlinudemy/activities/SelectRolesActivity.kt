package com.optic.deliverykotlinudemy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.optic.deliverykotlinudemy.R
import com.optic.deliverykotlinudemy.adapters.RolesAdapter
import com.optic.deliverykotlinudemy.models.Rol
import com.optic.deliverykotlinudemy.models.User
import com.optic.deliverykotlinudemy.utils.SharedPref

class SelectRolesActivity : AppCompatActivity() {

    var recyclerViewRoles: RecyclerView? = null
    var user: User? = null
    var adapter: RolesAdapter? = null
    var sharedPref: SharedPref? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_roles)
        sharedPref = SharedPref(this)
        recyclerViewRoles = findViewById(R.id.recyclerview_roles)
        recyclerViewRoles?.layoutManager = LinearLayoutManager(this)

        getUserFromSession()

        adapter = user?.roles?.let {
            RolesAdapter(this, it) }
        recyclerViewRoles?.adapter = adapter

    }

    private fun getUserFromSession() {

        val sharedPref = SharedPref(this)
        val gson = Gson()

        if (!sharedPref.getData("user").isNullOrBlank()) {
            // SI EL USARIO EXISTE EN SESION
            user = gson.fromJson(sharedPref.getData("user"), User::class.java)
        }

    }
}