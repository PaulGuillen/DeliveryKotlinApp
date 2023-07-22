package com.optic.deliverykotlinudemy.routes


import com.optic.deliverykotlinudemy.models.ResponseHttp
import com.optic.deliverykotlinudemy.models.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface UsersRoutes {

    @GET("users/findDeliveryMen")
    fun getDeliveryMen(
        @Header("Authorization") token: String
    ): Call<ArrayList<User>>

    @POST("users/create")
    fun register(@Body user: User): Call<ResponseHttp>

    @POST("users/login")
    fun login(@Body user: User): Call<ResponseHttp>

    @Multipart
    @PUT("users/update")
    fun update(
        @Part image: MultipartBody.Part,
        @Part("user") user: RequestBody,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>

    @PUT("users/updateWithoutImage")
    fun updateWithoutImage(
        @Body user: User,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>

    @PUT("users/updateNotificationToken")
    fun updateNotificationToken(
        @Body user: User,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>


}