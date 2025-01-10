package com.example.sistema_estacionamento.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R

class HomeView : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parks)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadDynamicData()

        registerEvents()
    }

    private fun loadDynamicData() {
        findViewById<TextView>(R.id.textview_user_name).text = MainActivity.currentUser?.name
    }

    private fun registerEvents() {
        findViewById<ConstraintLayout>(R.id.btnVeiculos).setOnClickListener {handleGoToVehicles()}
        findViewById<ConstraintLayout>(R.id.btnVagas).setOnClickListener {handleGoToParks()}
        // findViewById<AppCompatImageButton>(R.id.button_home_quit).setOnClickListener { handleQuit() }
    }

    private fun handleGoToParks() {
    }

    private fun handleGoToVehicles() {
        val vehiclesIntent = Intent(MainActivity.instance, VehiclesView::class.java)
        startActivity(vehiclesIntent)
    }

    private fun handleQuit() {
        val sharedPref = MainActivity.instance?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            remove("accessToken")
        }
        MainActivity.currentUser = null;

        val signInIntent = Intent(MainActivity.instance, SignInView::class.java)
        startActivity(signInIntent)
    }

}