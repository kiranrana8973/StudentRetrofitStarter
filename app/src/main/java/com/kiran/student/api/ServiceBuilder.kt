package com.kiran.student.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private const val BASE_URL = "http://10.0.2.2:3000/api/v1/"

    // private const val BASE_URL = "http://192.168.0.109:3000/api/v1/"
    var token: String? = null
    private val okHttp = OkHttpClient.Builder()

    //Create retrofit builder
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
        .build()

    //Generic function
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofitBuilder.create(serviceType)
    }

    // Load image path
    fun loadImagePath(): String {
        val arr = BASE_URL.split("/").toTypedArray()
        val a = arr[0] + "/" + arr[1] + arr[2] + "/uploads/"
        return a
    }
}