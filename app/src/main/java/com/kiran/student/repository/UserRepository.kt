package com.kiran.student.repository

import com.kiran.student.api.UserAPI
import com.kiran.student.api.MyApiRequest
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.model.User
import com.kiran.student.response.LoginResponse

class UserRepository : MyApiRequest(){

    private val myApi =
        ServiceBuilder.buildService(UserAPI::class.java)

    suspend fun checkUser(username : String,password :String) : LoginResponse{
        return apiRequest {
            myApi.checkUser(username,password)
        }
    }

    suspend fun registerUser(user : User) : LoginResponse{
        return apiRequest {
            myApi.registerUser(user)
        }
    }
}