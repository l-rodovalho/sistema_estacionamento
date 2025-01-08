package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R

class HomeView : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        registerEvents()
    }

    fun registerEvents() {
        findViewById<ConstraintLayout>(R.id.btnVeiculos).setOnClickListener {handleGoToVehicles()}
        findViewById<ConstraintLayout>(R.id.btnVagas).setOnClickListener {handleGoToParks()}
    }

    fun handleGoToParks() {
    }

    fun handleGoToVehicles() {
        val vehiclesIntent = Intent(MainActivity.instance, VehiclesView::class.java)
        startActivity(vehiclesIntent)
    }

}