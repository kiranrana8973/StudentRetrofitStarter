package com.kiran.student.ui

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kiran.student.R
import com.kiran.student.repository.NimanRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class NimanActivity : AppCompatActivity() {

    private lateinit var imgNiman: ImageView
    private lateinit var etNiman: EditText
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_niman)

        imgNiman = findViewById(R.id.imgNiman)
        etNiman = findViewById(R.id.etNiman)
        btn = findViewById(R.id.btn)

        imgNiman.setOnClickListener {
            openGallery()
        }
        btn.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val file = File(imageUrl!!)
                val reqFile =
                    RequestBody.create(MediaType.parse("multipart/form-data"), file)
                val body =
                    MultipartBody.Part.createFormData("pimage", file.name, reqFile)

                val fileBody = RequestBody.create(MediaType.parse("image/png"), file)

                val pname = RequestBody.create(MediaType.parse("multipart/form-data"), "Kiran")
                val pdesc = RequestBody.create(MediaType.parse("multipart/form-data"), "asdasdasd")
                val pprice = RequestBody.create(MediaType.parse("multipart/form-data"), "234234")

                val map: MutableMap<String, RequestBody> = mutableMapOf()
                map.put("pname", pname)
                map.put("pname", pdesc)
                map.put("pname", pprice)
                map.put("file\"; filename=\"pp.png\"", fileBody);

                val repository = NimanRepository()
                val response = repository.add(pname, pdesc, pprice, body)
                if (response.message == "Product Added!!") {
                    withContext(Main) {
                        Toast.makeText(this@NimanActivity, "Added", Toast.LENGTH_SHORT).show()
                    }
                }

            } catch (ex: Exception) {
                withContext(Main) {
                    Toast.makeText(this@NimanActivity, ex.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 1)
    }

    private var imageUrl: String? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            if (requestCode == 1) {
                val selectedImage = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val contentResolver = contentResolver
                val cursor =
                    contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
                cursor!!.moveToFirst()
                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                imageUrl = cursor.getString(columnIndex)
                imgNiman.setImageBitmap(BitmapFactory.decodeFile(imageUrl))
                cursor.close()
            }
        }
    }
}