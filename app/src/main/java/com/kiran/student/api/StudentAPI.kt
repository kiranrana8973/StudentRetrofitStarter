package com.kiran.student.api

import com.kiran.student.model.Student
import com.kiran.student.response.AddStudentResponse
import com.kiran.student.response.DeleteStudentResponse
import com.kiran.student.response.ImageResponse
import com.kiran.student.response.StudentResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface StudentAPI {

    @POST("student/")
    suspend fun insertStudent(
        @Header("Authorization") token: String,
        @Body student: Student
    ): Response<AddStudentResponse>

    @GET("student/")
    suspend fun getAllStudents(
        @Header("Authorization") token: String
    ): Response<StudentResponse>


    @DELETE("student/{id}")
    suspend fun deleteStudent(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<DeleteStudentResponse>





    @Multipart
    @PUT("student/{id}/photo")
    fun uploadImage(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Part file: MultipartBody.Part
    ): Call<ImageResponse>
}