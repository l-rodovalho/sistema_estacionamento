package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.views.adapters.ParkAdapter
import com.example.sistema_estacionamento.views.adapters.VehicleAdapter

class VehiclesView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)

        renderUserData();

        loadVehicles()

        registerEvents()
    }

    fun renderUserData() {
        findViewById<TextView>(R.id.textview_user_name).text = MainActivity.currentUser?.name as String
    }

    fun registerEvents() {
        findViewById<AppCompatImageView>(R.id.btn_navigation_parks).setOnClickListener {handleGoToParks()}
    }

    fun handleGoToParks() {
        val parksIntent = Intent(MainActivity.instance, ParksView::class.java);
        startActivity(parksIntent);
    }

    fun clearVehicles() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = VehicleAdapter(emptyList());
    }

    fun loadVehicles() {
        clearVehicles();
    }

}