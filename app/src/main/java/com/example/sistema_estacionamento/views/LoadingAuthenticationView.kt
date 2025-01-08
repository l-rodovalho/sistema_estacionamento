package com.example.sistema_estacionamento.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R

class LoadingAuthenticationView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        verifyToken()
    }

    fun verifyToken() {
        val sharedPref = MainActivity.instance?.getPreferences(Context.MODE_PRIVATE) ?: return
        val accessToken = sharedPref.getString("accessToken", "")
        if (accessToken != null) {
            if (accessToken.length > 0) {
                handleSuccess()
                return
            }
        }
        handleError()
    }

    fun handleSuccess() {
        val homeIntent = Intent(MainActivity.instance, HomeView::class.java)
        startActivity(homeIntent)
    }

    fun handleError() {
        val signInIntent = Intent(MainActivity.instance, SignInView::class.java)
        startActivity(signInIntent)
    }

}