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
""".trimIndent()
            val mediaType = "application/json".toMediaTypeOrNull()
            val body = RequestBody.create(mediaType, json)

            val request = Request.Builder()
                .url("http://themiranha.ddns.net:25565/authenticate")
                .post(body)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    // Tratar erro
                    Log.d("POST", "Quebrou ;(")
                    Log.d("POST", e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val resposta = response.body?.string()
                        val json = JSONObject(resposta);
                        val success = json.getBoolean("success")
                        if (success) {
                            val accessToken = json.getString("accessToken");
                            Log.d("POST", accessToken);
                            // armazenar o token
                            // ir para a tela principal do APP ( Home )
                        } else {
                            Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_LONG).show()
                        }

                    } else {
                        // Tratar resposta não bem-sucedida
                        Log.d("POST", "Caiu AQUI")
                    }
                }
            })

        }
             */

    }

}