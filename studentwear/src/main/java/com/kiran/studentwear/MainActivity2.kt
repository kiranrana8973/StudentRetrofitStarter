package com.kiran.studentwear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class MainActivity2 : WearableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Enables Always-on
        setAmbientEnabled()
    }
}