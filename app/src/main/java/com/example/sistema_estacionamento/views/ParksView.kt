package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.models.ParkModel
import com.example.sistema_estacionamento.views.adapters.ParkAdapter

class ParksView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadParks()

        registerEvents()
    }

    fun registerEvents() {
        findViewById<AppCompatImageView>(R.id.btnVeiculos).setOnClickListener {
            val homeIntent = Intent(MainActivity.instance, HomeView::class.java)
            startActivity(homeIntent)
        }
    }

    fun loadParks() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val parks = listOf(
            ParkModel("Vaga 1"),
            ParkModel("Vaga 2"),
            ParkModel("Vaga 3")
        )

        recyclerView.adapter = ParkAdapter(parks)
    }
}