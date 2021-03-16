package com.kiran.student.api

import com.kiran.student.response.NimanResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface NimanSirAPI {

    @Multipart
    @POST("product/insert")
    suspend fun addProduct(
        @Part("pname") pname: RequestBody,
        @Part("pdesc") pdesc: RequestBody,
        @Part("pprice") pprice: RequestBody,
        @Part("pimage") pimage: MultipartBody.Part
    ): Response<NimanResponse>

    @Multipart
    @POST("product/insert")
    suspend fun addProduct1(
        @PartMap mutableMap: MutableMap<String, RequestBody>
    ): Response<NimanResponse>
}