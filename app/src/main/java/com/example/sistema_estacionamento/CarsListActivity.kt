package com.example.sistema_estacionamento

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_list)

        // Configurar RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dados de exemplo
        val carros = listOf(
            Carro("Modelo A", "ABC-1234", "Disponível"),
            Carro("Modelo B", "XYZ-5678", "Ocupado"),
            Carro("Modelo C", "DEF-9101", "Manutenção")
        )

        recyclerView.adapter = CarAdapter(carros)
    }
}
