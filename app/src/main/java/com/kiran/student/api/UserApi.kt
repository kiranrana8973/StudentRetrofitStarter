package com.kiran.student.api

import com.kiran.student.model.User
import com.kiran.student.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun checkUser(
        @Field("username") username : String,
        @Field("password") password : String,
    ) : Response<LoginResponse>


    @POST("auth/register")
    suspend fun registerUser(
        @Body user : User
    ) : Response<LoginResponse>

}