package com.example.sistema_estacionamento

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VagasListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_list)

        // Configurar RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dados de exemplo
        val vagas = listOf(
            Vaga("1", "Vaga 1"),
            Vaga("2", "Vaga 2"),
            Vaga("3", "Vaga 3")
        )

        recyclerView.adapter = VagaAdapter(vagas)

        val btnReturn = findViewById<ImageView>(R.id.btn_return)
        btnReturn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}