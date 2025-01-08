package com.example.sistema_estacionamento.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.controllers.SignInController
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignInView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        registerEvents();
    }

    fun getEmail(): String {
        return findViewById<TextInputLayout>(R.id.txt_email_login).getEditText()?.getText().toString().trim();
    }

    fun getPassword(): String {
        return findViewById<TextInputLayout>(R.id.txt_password_login).getEditText()?.getText().toString().trim();
    }

    fun registerEvents() {
        findViewById<ConstraintLayout>(R.id.button_signup_submit)
            .setOnClickListener {
                SignInController.handle(getEmail(), getPassword(), ::handleError, ::handleSuccess)
            }
        findViewById<MaterialTextView>(R.id.btn_goTo_signUp)
            .setOnClickListener {
                val signUpIntent = Intent(MainActivity.instance, SignUpView::class.java)

                startActivity(signUpIntent)
            }
    }

    fun handleError() {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
        }
    }

    fun handleSuccess(accessToken: String) {
        val sharedPref = MainActivity.instance?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("accessToken", accessToken)
            apply()
        }

        val loadingAuthenticationIntent = Intent(MainActivity.instance, LoadingAuthenticationView::class.java)
        startActivity(loadingAuthenticationIntent)

    }

}