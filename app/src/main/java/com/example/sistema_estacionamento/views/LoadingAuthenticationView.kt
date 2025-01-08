package com.example.sistema_estacionamento.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sistema_estacionamento.MainActivity
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.controllers.UserDataController
import com.example.sistema_estacionamento.models.UserModel

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
                handleSuccess(accessToken)
                return
            }
        }
        handleError()
    }

    fun handleSuccess(accessToken: String) {
        UserDataController.handle(accessToken, ::handleError, ::handleUserData)
    }

    fun handleUserData(user: UserModel){
        MainActivity.currentUser = user;


        val homeIntent = Intent(MainActivity.instance, HomeView::class.java)
        startActivity(homeIntent)
    }

    fun handleError() {
        val signInIntent = Intent(MainActivity.instance, SignInView::class.java)
        startActivity(signInIntent)
    }

}