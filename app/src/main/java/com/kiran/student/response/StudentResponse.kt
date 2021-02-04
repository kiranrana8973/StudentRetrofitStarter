package com.kiran.student.response

import com.kiran.student.model.Student

data class StudentResponse(
    val success: Boolean? = null,
    val data: MutableList<Student>? =null
)