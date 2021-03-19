package com.kiran.mysharedlibrary

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyServiceBuilder {

    //private const val BASE_URL = "http://10.0.2.2:3000/api/v1/"
    //private const val BASE_URL = "http://localhost:3000/api/v1/"
    private const val BASE_URL = "http://10.0.2.2:3000/api/v1/"
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
        return arr[0] + "/" + arr[1] + arr[2] + "/uploads/"
    }
}