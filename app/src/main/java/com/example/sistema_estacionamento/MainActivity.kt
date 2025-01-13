package com.example.sistema_estacionamento

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistema_estacionamento.models.UserModel
import com.example.sistema_estacionamento.models.VehicleModel
import com.example.sistema_estacionamento.views.LoadingAuthenticationView
import com.example.sistema_estacionamento.views.SignInView
import com.example.sistema_estacionamento.views.VehiclesView

class MainActivity : AppCompatActivity() {

    companion object {
        var instance: MainActivity? = null
        var currentUser: UserModel? = null
        var vehicles: List<VehicleModel> = emptyList();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        instance = this;

        val intent = Intent(this, LoadingAuthenticationView::class.java)
        startActivity(intent)
    }
}