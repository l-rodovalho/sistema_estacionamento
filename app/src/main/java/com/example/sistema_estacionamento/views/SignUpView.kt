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
import com.example.sistema_estacionamento.controllers.SignUpController
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignUpView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        registerEvents();
    }

    private fun getEmail(): String {
        return findViewById<TextInputLayout>(R.id.textinput_signup_email).getEditText()?.getText().toString().trim();
    }

    private fun getPassword(): String {
        return findViewById<TextInputLayout>(R.id.textinput_signup_password).getEditText()?.getText().toString().trim();
    }

    private fun getName(): String {
        return findViewById<TextInputLayout>(R.id.textinput_signup_name).getEditText()?.getText().toString().trim();
    }

    fun registerEvents() {
        findViewById<MaterialTextView>(R.id.btn_goTo_signIn).setOnClickListener {
            val signInIntent = Intent(MainActivity.instance, SignInView::class.java)
            startActivity(signInIntent)
        }
        findViewById<ConstraintLayout>(R.id.button_signup_submit).setOnClickListener {
            SignUpController.handle(getEmail(), getPassword(), getName(), ::handleError, ::handleSuccess)
        }
    }

    fun handleError(message: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(MainActivity.instance, message, Toast.LENGTH_LONG)
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