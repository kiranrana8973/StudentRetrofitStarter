package com.kiran.studentwear

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.Toast
import com.kiran.mysharedlibrary.Arithmetic

class MainActivity : WearableActivity() {

    private lateinit var btnAdd : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {

            val arithmetic = Arithmetic()
            Toast.makeText(this, arithmetic.add().toString(), Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,MainActivity2::class.java))
        }

        // Enables Always-on
        setAmbientEnabled()
    }
}