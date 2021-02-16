package com.kiran.student.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val _id : String="",
    val fname : String? = null,
    val lname : String? = null,
    val username : String? = null,
    val password : String? = null,
)