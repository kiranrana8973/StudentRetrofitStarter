package com.kiran.student.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.kiran.student.R
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.repository.UserRepository
import kotlinx.coroutines.*
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    var username: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        CoroutineScope(Dispatchers.Main).launch {
            getSharedPref()
            if (username != "") {
                login()
            } else {
                // Start login page
                loadLoginPage()
            }
        }
    }

    private fun loadLoginPage() {
        startActivity(
            Intent(
                this@SplashActivity,
                LoginActivity::class.java
            )
        )
        finish()
    }

    private fun login() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.checkUser(username!!, password!!)
                if (response.success == true) {
                    // Save token
                    ServiceBuilder.token = "Bearer ${response.token}"
                    startActivity(
                        Intent(
                            this@SplashActivity,
                            DashboardActivity::class.java
                        )
                    )
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        loadLoginPage()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@SplashActivity,
                        ex.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun getSharedPref() {
        val sharedPref = getSharedPreferences("UsernamePasswordPref", MODE_PRIVATE)
        username = sharedPref.getString("username", "")
        password = sharedPref.getString("password", "")
    }
}