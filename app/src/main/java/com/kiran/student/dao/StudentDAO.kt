package com.kiran.student.dao

import androidx.room.*
import com.kiran.student.model.Student

@Dao
interface StudentDAO {
    @Insert
    suspend fun insertStudent(student : Student)

    val a : Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBulkStudent(student: List<Student>)

    @Query("SELECT * FROM Student")
    suspend fun getAllStudents() : MutableList<Student>

    @Update
    suspend fun updateStudent(student : Student)

    @Delete
    suspend fun DeleteStudent(student : Student)

    @Query("DELETE FROM Student")
    suspend fun DeleteAllStudents()
}