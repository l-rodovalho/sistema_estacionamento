package com.example.sistema_estacionamento

import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class API {

    companion object {

        val HOST = "http://themiranha.ddns.net:25565"

        fun POST(json: String, calBack: Callback) {
            val client = OkHttpClient()

            val mediaType = "application/json".toMediaTypeOrNull()
            val body = RequestBody.create(mediaType, json)

            val request = Request.Builder()
                .url(HOST)
                .post(body)
                .build()

            client.newCall(request).enqueue(calBack)
        }

        fun GET(callBack: Callback) {
            val client = OkHttpClient();

            val request = Request.Builder()
                .url(HOST)
                .build()

            client.newCall(request).enqueue(callBack)
        }
    }

   /*

    object : Callback {
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
    }

    */


}