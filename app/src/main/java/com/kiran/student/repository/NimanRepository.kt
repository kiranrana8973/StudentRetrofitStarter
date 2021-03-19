package com.kiran.student.repository

import com.kiran.student.api.MyApiRequest
import com.kiran.student.api.NimanSirAPI
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.response.NimanResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody

class NimanRepository : MyApiRequest() {
    val token = "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2MDUzZmU3YzkzOTE2OTIzNDA0MGVmMDYiLCJpYXQiOjE2MTYxMTc0MTZ9.CSDftvQPotD1SUs3ypMj9LvmokUm8dxj6I_Hr7iSg8"
    val nimanSirAPI =
        ServiceBuilder.buildService(NimanSirAPI::class.java)

    suspend fun add(pname: RequestBody, pdesc: RequestBody, pprice: RequestBody, body: MultipartBody.Part) : NimanResponse {
        return apiRequest {
            nimanSirAPI.addProduct(pname,pdesc,pprice,body)
        }
    }

}