package com.example.sistema_estacionamento.controllers

import android.util.Log
import com.example.sistema_estacionamento.models.UserModel
import com.example.sistema_estacionamento.utils.API
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONObject

class UserDataController {

    companion object {

        fun handle(accessToken: String, handleError: () -> Unit, handleSuccess: (user: UserModel) -> Unit) {
            API.GET("/user", object: Callback {
                override fun onFailure(call: Call, e: java.io.IOException) {
                    handleError()
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val response = response.body?.string()
                        val json = JSONObject(response);
                        val success = json.getBoolean("success")
                        if (success) {

                            val userData = json.getJSONObject("user")
                            val id = userData.getString("id")
                            val name = userData.getString("name")
                            val email = userData.getString("email")
                            handleSuccess(UserModel(id, name, email, accessToken))
                        } else {
                            handleError()
                        }
                    } else {
                        handleError()
                    }
                }
            }, accessToken)
        }

    }

}