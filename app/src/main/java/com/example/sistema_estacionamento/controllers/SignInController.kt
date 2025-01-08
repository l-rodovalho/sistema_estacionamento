package com.example.sistema_estacionamento.controllers

import com.example.sistema_estacionamento.utils.API
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import okio.IOException
import org.json.JSONObject

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
            }, null)
            return false
        }

    }

}