package com.example.sistema_estacionamento.controllers

import android.util.Log
import com.example.sistema_estacionamento.models.ParkModel
import com.example.sistema_estacionamento.models.VehicleModel
import com.example.sistema_estacionamento.utils.API
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class VehicleController {

    companion object {

        fun getVehicles(accessToken: String, handleError: () -> Unit, handleSuccess: (List<VehicleModel>) -> Unit) {
            API.GET("/vehicles", object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    handleError();
                }

                override fun onResponse(call: Call, response: Response) {
                    var vehiclesToReturn = emptyList<VehicleModel>();

                    if (response.isSuccessful) {
                        val response = response.body?.string()
                        val json = JSONObject(response);
                        val success = json.getBoolean("success");
                        if (success) {
                            val vehicles = json.getJSONArray("vehicles");
                            val vehiclesLength = vehicles.length();
                            for (i in 0..vehiclesLength-1) {
                                val vehicleObject = vehicles.getJSONObject(i);
                                val vehiclePlate = vehicleObject.getString("plate");
                                vehiclesToReturn = vehiclesToReturn + VehicleModel(vehiclePlate);
                            }
                            handleSuccess(vehiclesToReturn);
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

    }
}