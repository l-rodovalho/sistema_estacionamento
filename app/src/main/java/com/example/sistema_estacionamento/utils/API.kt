package com.example.sistema_estacionamento.utils

import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class API {

    companion object {

        val HOST = "http://10.10.100.220:25565"

        fun POST(route: String, payload: String, calBack: Callback, accessToken: String?) {

            val client = OkHttpClient()


            val mediaType = "application/json".toMediaTypeOrNull()
            val body = payload.toRequestBody(mediaType)

            var request = Request.Builder()
                .url(HOST + route)
                .post(body)
                .build()

            if (accessToken != null) {
                request = Request.Builder()
                    .url(HOST + route)
                    .post(body)
                    .header("authorization", "Bearer $accessToken")
                    .build()
            }

            client.newCall(request).enqueue(calBack)
        }

        fun GET(route: String, callBack: Callback, accessToken: String?) {
            val client = OkHttpClient();

            var request = Request.Builder()
                .url(HOST + route)
                .build()

            if (accessToken != null) {
                request = Request.Builder()
                    .url(HOST + route)
                    .header("authorization", "Bearer $accessToken")
                    .build()
            }


            client.newCall(request).enqueue(callBack)
        }
    }

}