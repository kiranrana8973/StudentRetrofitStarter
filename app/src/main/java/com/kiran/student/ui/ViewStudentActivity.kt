package com.kiran.student.ui

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiran.student.R
import com.kiran.student.adapter.StudentAdapter
import com.kiran.student.model.Student
import com.kiran.student.notification.NotificationChannels
import com.kiran.student.repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ViewStudentActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)
        recyclerView = findViewById(R.id.recyclerView)

        loadStudents()
    }

    private fun loadStudents() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val studentRepository = StudentRepository()
                val response = studentRepository.getAllStudents()
                if (response.success == true) {
                    // Insert all the students in room database
                    studentRepository.insertBulkStudent(this@ViewStudentActivity, response.data!!)

                    // get data from room database
                    val lstStudents =
                        studentRepository.getAllStudentsFromRoom(this@ViewStudentActivity)

                    showNotification(lstStudents.size)
                    withContext(Main) {
                        recyclerView.adapter =
                            StudentAdapter(this@ViewStudentActivity, lstStudents!!)
                        recyclerView.layoutManager = LinearLayoutManager(this@ViewStudentActivity)
                    }
                }
            } catch (ex: Exception) {
                withContext(Main) {
                    Toast.makeText(
                        this@ViewStudentActivity,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun showNotification(size: Int) {
        val notificationManager = NotificationManagerCompat.from(this)
        val activityIntent = Intent(this, MapsActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, activityIntent, 0)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("My notification")
            .setContentText("Total number of students are $size")
            .setColor(Color.BLUE)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(1, notification)
    }

}
