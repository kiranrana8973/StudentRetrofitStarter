package com.kiran.student.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Date

@Entity
data class Student(
    @PrimaryKey
    val _id: String = "",
    val fullname: String? = null,
    val age: Int? = null,
    val gender: String? = null,
    val address: String? = null,
    val photo: String? = null
)