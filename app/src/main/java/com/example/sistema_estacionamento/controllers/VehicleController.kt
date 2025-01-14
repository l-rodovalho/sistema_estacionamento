package com.example.sistema_estacionamento.controllers

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.models.VehicleModel
import com.example.sistema_estacionamento.utils.API
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class VehicleController {

    companion object {

        fun postVehicle(accesToken: String, plate: String, handleError: (errorMessage: String) -> Unit, handleSuccess: () -> Unit): Boolean {

            val payload = """
                {
                    "plate": "$plate",
                }
            """.trimIndent();

            API.POST("/plate/create-plate", payload, object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    handleError("Ocorreu um erro...");
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val response = response.body?.string()
                        val json = JSONObject(response);
                        val success = json.getBoolean("success");

                        if (success) {
                            handleSuccess();
                        } else {
                            val message = json.getString("message")
                            handleError(message)
                        }
                    }
                    handleError("F");
                }
            }, accesToken);

            return false;
        }
    }
}