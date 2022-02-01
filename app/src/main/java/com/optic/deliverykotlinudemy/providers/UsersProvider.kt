package com.optic.deliverykotlinudemy.providers

import com.optic.deliverykotlinudemy.api.ApiRoutes
import com.optic.deliverykotlinudemy.models.ResponseHttp
import com.optic.deliverykotlinudemy.models.User
import com.optic.deliverykotlinudemy.routes.UsersRoutes
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import java.io.File

class UsersProvider(val token: String? = null) {

    private var usersRoutes: UsersRoutes? = null
    private var userRoutesToken: UsersRoutes? = null

    init {
        val api = ApiRoutes()
        usersRoutes = api.getUsersRoutes()

        if(token != null){
            userRoutesToken = api.getUsersRoutesWithToken(token!!)
        }

    }

    fun getDeliveryMen(): Call<ArrayList<User>>? {
        return userRoutesToken?.getDeliveryMen(token!!)
    }

    fun register(user: User): Call<ResponseHttp>? {
        return usersRoutes?.register(user)
    }

    fun login(email: String, password: String): Call<ResponseHttp>? {
        return usersRoutes?.login(email, password)
    }

    fun updateWithoutImage(user: User): Call<ResponseHttp>? {
        return userRoutesToken?.updateWithoutImage(user, token!!)
    }

    fun update(file: File, user: User): Call<ResponseHttp>? {
        val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
        val image = MultipartBody.Part.createFormData("image", file.name, reqFile)
        val requestBody = RequestBody.create(MediaType.parse("text/plain"), user.toJson())
        return userRoutesToken?.update(image, requestBody , token!!)
    }

}