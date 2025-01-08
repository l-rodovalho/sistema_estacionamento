package com.example.sistema_estacionamento.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.google.android.material.textview.MaterialTextView

class SignUpView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        registerEvents();
    }

    fun registerEvents() {
        findViewById<MaterialTextView>(R.id.btn_goTo_signIn).setOnClickListener {
            val signInIntent = Intent(MainActivity.instance, SignInView::class.java)

            startActivity(signInIntent)
        }
    }

}