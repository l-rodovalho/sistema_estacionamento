package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.controllers.ParkController
import com.example.sistema_estacionamento.models.ParkModel
import com.example.sistema_estacionamento.utils.API
import com.example.sistema_estacionamento.views.adapters.ParkAdapter

class ParksView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parks)

        renderUserData();

        loadParks()

        registerEvents()
    }

    fun renderUserData() {
        if (MainActivity.currentUser?.name != null) {
            findViewById<TextView>(R.id.textview_user_name).text = MainActivity.currentUser?.name as String
        }
    }

    fun registerEvents() {
        findViewById<AppCompatImageView>(R.id.btn_navigation_vehicles).setOnClickListener {handleGoToVehicles()}
    }

    fun handleGoToVehicles() {
        val vehiclesIntent = Intent(MainActivity.instance, VehiclesView::class.java);
        startActivity(vehiclesIntent);
    }

    fun loadParks() {

        ParkController.getParks(MainActivity.currentUser?.accessToken as String, ::handleErrorParks, ::handleSuccessParks);
    }

    fun handleSuccessParks(parks: List<ParkModel>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        recyclerView.layoutManager = LinearLayoutManager(this);

       recyclerView.adapter = ParkAdapter(parks);
    }

    fun handleErrorParks() {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(MainActivity.instance, "Ops... Ocorreu um erro", Toast.LENGTH_LONG).show();
        }
    }
}