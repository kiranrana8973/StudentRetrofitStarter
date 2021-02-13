package com.kiran.student.repository

import android.app.Service
import com.kiran.student.api.MyApiRequest
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.api.StudentAPI
import com.kiran.student.model.Student
import com.kiran.student.response.AddStudentResponse
import com.kiran.student.response.DeleteStudentResponse
import com.kiran.student.response.ImageResponse
import com.kiran.student.response.StudentResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart

class StudentRepository : MyApiRequest() {

    private val studentAPI = ServiceBuilder.buildService(StudentAPI::class.java)

    suspend fun insertStudent(student: Student): AddStudentResponse {
        return apiRequest {
            studentAPI.insertStudent(ServiceBuilder.token!!, student)
        }
    }

    suspend fun getAllStudents(): StudentResponse {
        return apiRequest {
            studentAPI.getAllStudents(ServiceBuilder.token!!)
        }
    }

    suspend fun deleteStudents(id: String): DeleteStudentResponse {
        return apiRequest {
            studentAPI.deleteStudent(ServiceBuilder.token!!, id)
        }
    }

    suspend fun uploadImage(id: String, body: MultipartBody.Part): ImageResponse {
        return apiRequest {
            studentAPI.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }
}
