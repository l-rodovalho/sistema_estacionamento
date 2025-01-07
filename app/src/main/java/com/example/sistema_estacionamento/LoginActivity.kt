package com.example.sistema_estacionamento

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class LoginActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        registerButtonEvents();
    }

    fun registerButtonEvents() {

        val btn_login = findViewById<ConstraintLayout>(R.id.btn_login);
        btn_login.setOnClickListener {

            Log.d("POST", "started");


            /*
            val client = OkHttpClient()

            val json = """
    {
        "email": "email@email.com",
        "password": "senha123"
    }
""".trimIndent()*/
           }

    }

}