package com.example.sistema_estacionamento.controllers

import android.util.Log
import com.example.sistema_estacionamento.models.ParkModel
import com.example.sistema_estacionamento.utils.API
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class ParkController {

    companion object {

        fun getParks(accessToken: String, handleError: () -> Unit, handleSuccess: (List<ParkModel>) -> Unit) {
            API.GET("/parks", object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    handleError();
                }

                override fun onResponse(call: Call, response: Response) {
                    var parksToReturn = emptyList<ParkModel>();

                    if (response.isSuccessful) {
                        val response = response.body?.string()
                        val json = JSONObject(response);
                        val success = json.getBoolean("success");
                        if (success) {
                            val parks = json.getJSONArray("parks");
                            val parksLength = parks.length();
                            for (i in 0..parksLength-1) {
                                val parkObject = parks.getJSONObject(i);
                                val parkId = parkObject.getString("id");
                                val parkName = parkObject.getString("name");
                                var owned = true
                                if (parkObject.isNull("parking")) {
                                    owned = false;
                                }
                                parksToReturn = parksToReturn + ParkModel(parkId, parkName, owned);
                            }
                            handleSuccess(parksToReturn);
                        } else {
                            Log.d("API", response as String);
                            handleError();
                        }
                    } else {
                        handleError();
                    }
                }
            }, accessToken);
        }

        fun buy(accessToken: String, parkId: String, plate: String, time: Number, handleError: (errorMessage: String) -> Unit, handleSuccess: () -> Unit): Boolean {

            val payload = """
                {
                    "parkId": "$parkId",
                    "plateId": "$plate",
                    "timeInSeconds": $time
                }
            """.trimIndent();

            API.POST("/parking/buy", payload, object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    handleError("Ocorreu um erro...")
                }
                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val response = response.body?.string()
                        val json = JSONObject(response)
                        val success = json.getBoolean("success")
                        if (success) {
                            handleSuccess()
                            return
                        } else {
                            val message = json.getString("message")
                            handleError(message)
                        }
                    }
                    handleError("F");
                }
            }, accessToken)

            return false;
        }

    }

}