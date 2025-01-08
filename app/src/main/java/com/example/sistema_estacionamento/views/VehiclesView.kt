package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.models.VehicleModel
import com.example.sistema_estacionamento.views.adapters.VehicleAdapter

class VehiclesView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)

        loadVehicles()

        registerEvents()
    }

    fun registerEvents() {
        findViewById<AppCompatImageView>(R.id.btn_return).setOnClickListener {
            val homeIntent = Intent(MainActivity.instance, HomeView::class.java)
            startActivity(homeIntent)
        }
    }

    fun loadVehicles() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val vehicles = listOf(
            VehicleModel("ABC-1234")
        )

        recyclerView.adapter = VehicleAdapter(vehicles)
    }

}