package com.optic.deliverykotlinudemy.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.optic.deliverykotlinudemy.R
import com.optic.deliverykotlinudemy.activities.client.address.list.ClientAddressListActivity
import com.optic.deliverykotlinudemy.activities.client.home.ClientHomeActivity
import com.optic.deliverykotlinudemy.activities.client.products.list.ClientProductsListActivity
import com.optic.deliverykotlinudemy.activities.delivery.home.DeliveryHomeActivity
import com.optic.deliverykotlinudemy.activities.restaurant.home.RestaurantHomeActivity
import com.optic.deliverykotlinudemy.models.Address
import com.optic.deliverykotlinudemy.models.Category
import com.optic.deliverykotlinudemy.models.Rol
import com.optic.deliverykotlinudemy.utils.SharedPref

class AddressAdapter(val context: Activity, val address: ArrayList<Address>): RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {

    val sharedPref = SharedPref(context)
    val gson = Gson()
    var prev = 0
    var positionAddressSession = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_address, parent, false)
        return AddressViewHolder(view)
    }

    override fun getItemCount(): Int {
        return address.size
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {

        val a = address[position] // CADA UNA DE LAS DIRECCIONES

        if (!sharedPref.getData("address").isNullOrBlank()) { // SI EL USUARIO ELIJIO UNA DIRECCION DE LA LISTA
            val adr = gson.fromJson(sharedPref.getData("address"), Address::class.java)

            if (adr.id == a.id) {
                positionAddressSession = position
                holder.imageViewCheck.visibility = View.VISIBLE
            }
        }

        holder.textViewAddress.text = a.address
        holder.textViewNeighborhood.text = a.neighborhood

        holder.itemView.setOnClickListener {

            (context as ClientAddressListActivity).resetValue(prev)
            (context as ClientAddressListActivity).resetValue(positionAddressSession)
            prev = position // 1

            holder.imageViewCheck.visibility = View.VISIBLE
            saveAddress(a.toJson())
        }
    }

    private fun saveAddress(data: String) {
        val ad = gson.fromJson(data, Address::class.java)
        sharedPref.save("address", ad)
    }

    class AddressViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textViewAddress: TextView
        val textViewNeighborhood: TextView
        val imageViewCheck: ImageView

        init {
            textViewAddress = view.findViewById(R.id.textview_address)
            textViewNeighborhood = view.findViewById(R.id.textview_neighborhood)
            imageViewCheck = view.findViewById(R.id.imageview_check)
        }

    }

}