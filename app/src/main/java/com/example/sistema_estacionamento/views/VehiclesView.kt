package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.controllers.VehicleController
import com.example.sistema_estacionamento.models.VehicleModel
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
        findViewById<ImageView>(R.id.btn_new_vehicle).setOnClickListener {handleGoToNewVehicle()}
    }

    fun handleGoToParks() {
        val parksIntent = Intent(MainActivity.instance, ParksView::class.java);
        startActivity(parksIntent);
    }

    fun handleGoToNewVehicle() {
        val newVehicleIntent = Intent(MainActivity.instance, NewVehicleView::class.java);
        startActivity(newVehicleIntent);
    }

    fun clearVehicles() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = VehicleAdapter(emptyList());
    }

    fun loadVehicles() {
        // clearVehicles();

        VehicleController.getVehicles(MainActivity.currentUser?.accessToken as String, ::handleErrorVehicles, ::handleSuccessVehicles);
    }

    fun handleSuccessVehicles(vehicles: List<VehicleModel>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        recyclerView.layoutManager = LinearLayoutManager(this);

        recyclerView.adapter = VehicleAdapter(vehicles);
    }

    fun handleErrorVehicles() {
        Toast.makeText(MainActivity.instance, "Ops... Ocorreu um erro", Toast.LENGTH_LONG).show();
    }

}