package com.kiran.student.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kiran.student.dao.StudentDAO
import com.kiran.student.dao.UserDAO
import com.kiran.student.model.Student
import com.kiran.student.model.User


@Database(
    entities = [(Student::class), (User::class)],
    version = 2,
    exportSchema = false
)
abstract class StudentDB : RoomDatabase() {
    abstract fun getStudentDAO(): StudentDAO
    abstract fun getUserDAO(): UserDAO

    companion object {
        @Volatile
        private var instance: StudentDB? = null

        fun getInstance(context: Context): StudentDB {
            if (instance == null) {
                synchronized(StudentDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StudentDB::class.java,
                "StudentDB"
            ).build()
    }
}