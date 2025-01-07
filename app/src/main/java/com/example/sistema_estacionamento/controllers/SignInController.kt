package com.example.sistema_estacionamento.controllers

import android.util.Log
import com.example.sistema_estacionamento.API
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okio.IOException
import org.json.JSONObject
import java.lang.Error

class SignInController {

    companion object {

        fun handle(email: String, password: String, handleError: () -> Unit, handleSuccess: (accessToken: String) -> Unit): Boolean {


            val payload = """
                {
                	"email": "$email",
                	"password": "$password"
                }
            """.trimIndent()

            API.POST("/authenticate", payload, object : Callback {
                override fun onFailure(call: Call, error: IOException) {
                    handleError()
                }
                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val resposta = response.body?.string()
                        val json = JSONObject(resposta);
                        val success = json.getBoolean("success")
                        if (success) {
                            val accessToken = json.getString("accessToken");
                            handleSuccess(accessToken)
                        } else {
                            handleError()
                        }
                    } else {
                        handleError()
                    }
                }
            })
            return false
        }

    }

}