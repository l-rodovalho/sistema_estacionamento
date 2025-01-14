package com.example.sistema_estacionamento.controllers

import android.util.Log
import com.example.sistema_estacionamento.utils.API
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import okio.IOException
import org.json.JSONObject

class SignUpController {

    companion object {

        fun handle(email: String, password: String, name: String, handleError: (errorMessage: String) -> Unit, handleSuccess: (accessToken: String) -> Unit): Boolean {

            val payload = """
                {
                    "email": "$email",
                    "password": "$password",
                    "name": "$name"
                }
            """.trimIndent();

            API.POST("/create-account", payload, object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    handleError("Ocorreu um erro...")
                }
                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val response = response.body?.string()
                        val json = JSONObject(response)
                        val success = json.getBoolean("success")
                        if (success) {
                            val accessToken = json.getString("accessToken")
                            handleSuccess(accessToken)
                        } else {
                            val message = json.getString("message")
                            handleError(message)
                        }
                    }
                    handleError("F");
                }
            }, null)

            return false;
        }

    }

}