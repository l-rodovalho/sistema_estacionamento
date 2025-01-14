package com.example.sistema_estacionamento

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.sistema_estacionamento.controllers.SignUpController
import com.example.sistema_estacionamento.databinding.FragmentSignInBinding
import com.example.sistema_estacionamento.databinding.FragmentSignUpBinding
import com.example.sistema_estacionamento.models.UserModel
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerEvents()
    }

    private fun getEmail(): String {
        return binding.textinputSignupEmail.getEditText()?.getText().toString().trim();
    }

    private fun getPassword(): String {
        return binding.textinputSignupPassword.getEditText()?.getText().toString().trim();
    }

    private fun getName(): String {
        return binding.textinputSignupName.getEditText()?.getText().toString().trim();
    }

    fun registerEvents() {
        binding.btnGoToSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
        binding.buttonSignupSubmit.setOnClickListener {
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

        MainActivity.currentUser = UserModel("", "", "", accessToken)


        Handler(Looper.getMainLooper()).post {
            findNavController().navigate(R.id.action_signUpFragment_to_loadingFragment)
        }
    }
}