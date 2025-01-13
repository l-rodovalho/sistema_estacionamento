package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R

class NewVehicleView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_vehicle)

        registerEvents()
    }

    private fun registerEvents() {
        findViewById<ImageView>(R.id.btn_return).setOnClickListener { handleReturnToVehicles() }
    }

    private fun handleReturnToVehicles() {
        val vehiclesIntent = Intent(MainActivity.instance, VehiclesView::class.java)
        startActivity(vehiclesIntent)
    }
}