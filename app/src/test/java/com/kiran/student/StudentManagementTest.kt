package com.kiran.student

import com.kiran.student.api.ServiceBuilder
import com.kiran.student.model.Student
import com.kiran.student.model.User
import com.kiran.student.repository.StudentRepository
import com.kiran.student.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class StudentManagementTest {

    private lateinit var userRepository: UserRepository
    private lateinit var studentRepository: StudentRepository

    // -----------------------------User Testing-----------------------------
    @Test
    fun checkLogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.checkUser("kiran", "kiran123")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun registerUser() = runBlocking {
        val user =
            User(fname = "test", lname = "test", username = "testuser", password = "testpassword")
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    // -----------------------------Student Testing-----------------------------
    @Test
    fun addStudent() = runBlocking {
        userRepository = UserRepository()
        val student =
            Student(fullname = "fullName", age = 33, gender = "gender", address = "address")
        studentRepository = StudentRepository()
        ServiceBuilder.token ="Bearer " + userRepository.checkUser("kiran","kiran123").token
        val expectedResult = true
        val actualResult = studentRepository.insertStudent(student).success
        Assert.assertEquals(expectedResult, actualResult)
    }
}