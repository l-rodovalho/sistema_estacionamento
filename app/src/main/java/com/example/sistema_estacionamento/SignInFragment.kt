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
import com.example.sistema_estacionamento.controllers.SignInController
import com.example.sistema_estacionamento.databinding.FragmentParksBinding
import com.example.sistema_estacionamento.databinding.FragmentSignInBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerEvents()
    }

    fun getEmail(): String {
        return binding.txtEmailLogin.getEditText()?.getText().toString().trim();
    }

    fun getPassword(): String {
        return binding.txtPasswordLogin.getEditText()?.getText().toString().trim();
    }

    fun registerEvents() {
        binding.buttonSigninSubmit
            .setOnClickListener {
                SignInController.handle(getEmail(), getPassword(), ::handleError, ::handleSuccess)
            }
        binding.btnGoToSignUp
            .setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
            }
    }

    fun handleError() {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(context, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
        }
    }

    fun handleSuccess(accessToken: String) {
        val sharedPref = MainActivity.instance?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("accessToken", accessToken)
            apply()
        }

        findNavController().navigate(R.id.action_signInFragment_to_parksFragment)
    }

}