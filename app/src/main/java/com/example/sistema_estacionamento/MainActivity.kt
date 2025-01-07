package com.example.sistema_estacionamento

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        // Aplicar padding para barras do sistema
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //    insets
        //}

        // Configurar clique no botão "Veículos"
        //val btnVeiculos = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.btnVeiculos)
        //btnVeiculos.setOnClickListener {
            // Abrir a tela da lista de carros
        //    val intent = Intent(this, CarsListActivity::class.java)
        //    startActivity(intent)
        //}
    }
}
