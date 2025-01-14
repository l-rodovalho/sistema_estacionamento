package com.example.sistema_estacionamento

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistema_estacionamento.models.ParkModel
import com.example.sistema_estacionamento.models.UserModel
import com.example.sistema_estacionamento.models.VehicleModel

class MainActivity : AppCompatActivity() {

    companion object {
        var instance: MainActivity? = null
        var currentUser: UserModel? = null
        var vehicles: List<VehicleModel> = emptyList();
        var parks: List<ParkModel> = emptyList();

        fun reset() {
            currentUser = null;
            vehicles = emptyList();
            parks = emptyList();
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        instance = this;

        setContentView(R.layout.activity_main)
    }
}