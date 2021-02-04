package com.kiran.student.ui

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import com.kiran.student.R
import com.kiran.student.api.ServiceBuilder

class DashboardActivity : AppCompatActivity() {

    private lateinit var btnAddStudent : AppCompatImageButton
    private lateinit var btnViewStudent : AppCompatImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnAddStudent = findViewById(R.id.btnAddStudent)
        btnViewStudent = findViewById(R.id.btnViewStudent)

        btnAddStudent.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,AddstudentActivity::class.java))
        }

        btnViewStudent.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,ViewStudentActivity::class.java))
        }
    }
}