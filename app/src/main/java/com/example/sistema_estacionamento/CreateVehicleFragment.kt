package com.example.sistema_estacionamento

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sistema_estacionamento.controllers.VehicleController
import com.example.sistema_estacionamento.databinding.FragmentCreateVehicleBinding
import com.example.sistema_estacionamento.databinding.FragmentLoadingBinding
import com.example.sistema_estacionamento.models.VehicleModel

class CreateVehicleFragment : Fragment() {

    private lateinit var binding: FragmentCreateVehicleBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateVehicleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerEvents()
    }

    fun registerEvents() {
        binding.btnCreatevehicleSubmit.setOnClickListener {handleSubmit()}
    }

    private fun getPlate(): String {
        return binding.textinputCreatevehiclePlate.text.toString();
    }

    fun handleSubmit() {
        VehicleController.create(MainActivity.currentUser?.accessToken as String, getPlate(), ::handleError, ::handleSuccess)
    }

    fun handleSuccess() {
        MainActivity.vehicles = MainActivity.vehicles + VehicleModel(getPlate())
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(MainActivity.instance, "Placa cadastrada com sucesso!", Toast.LENGTH_LONG)
            findNavController().navigate(R.id.action_createVehicleFragment_to_vehicleFragment)
        }
    }

    fun handleError(message: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(MainActivity.instance, message, Toast.LENGTH_LONG)
        }
    }

}