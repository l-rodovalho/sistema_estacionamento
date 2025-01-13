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
import androidx.navigation.fragment.findNavController
import com.example.sistema_estacionamento.controllers.UserDataController
import com.example.sistema_estacionamento.databinding.FragmentLoadingBinding
import com.example.sistema_estacionamento.models.UserModel
import com.example.sistema_estacionamento.models.VehicleModel


class LoadingFragment : Fragment() {


    private lateinit var binding: FragmentLoadingBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//            findNavController().navigate(R.id.action_loadingFragment_to_parksFragment)
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

    fun handleUserData(user: UserModel, vechiles: List<VehicleModel>){
        MainActivity.currentUser = user;
        MainActivity.vehicles = vechiles;

        Handler(Looper.getMainLooper()).post {
            findNavController().navigate(R.id.action_loadingFragment_to_parksFragment)
        }

    }

    fun handleError() {
        findNavController().navigate(R.id.action_loadingFragment_to_signInFragment)
    }


}