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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sistema_estacionamento.controllers.ParkController
import com.example.sistema_estacionamento.databinding.FragmentParksBinding
import com.example.sistema_estacionamento.databinding.FragmentSelectVehicleBinding
import com.example.sistema_estacionamento.views.adapters.ParkAdapter
import com.example.sistema_estacionamento.views.adapters.VehicleSelectorAdapter

class SelectVehicleFragment : Fragment() {

    private lateinit var binding: FragmentSelectVehicleBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectVehicleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBuyparkSubmit.isClickable = false;
        binding.btnBuyparkSubmit.isEnabled = false;

        registerEvents();

        renderVehicles();
    }

    fun registerEvents() {
        binding.btnBuyparkSubmit.setOnClickListener {handleSubmit()}
    }

    fun renderVehicles() {
        val recyclerView = binding.recyclerBuypark;
        recyclerView.layoutManager = LinearLayoutManager(context);

        recyclerView.adapter = VehicleSelectorAdapter(MainActivity.vehicles, ::handleSelectVehicle);
    }

    fun handleSelectVehicle(plate: String) {
        MainActivity.currentPlate = plate
        binding.btnBuyparkSubmit.isClickable = true;
        binding.btnBuyparkSubmit.isEnabled = true;
        binding.textBuyparkText.text = "Placa: $plate";
    }

    fun getTime(): Number {
        return binding.textInputBuyparkSeconds.text.toString().toInt();
    }

    fun handleSubmit(): Boolean {
        if (MainActivity.currentUser == null) return false;
        if (MainActivity.currentPark == null) return false;
        if (MainActivity.currentPlate == null) return false;

        ParkController.buy(MainActivity.currentUser?.accessToken as String, MainActivity.currentPark?.id as String, MainActivity.currentPlate as String, getTime(), ::handleError, ::handleSuccess)
        return true;
    }

    fun resetData() {
        MainActivity.currentPlate = null;
        MainActivity.currentPark = null;
    }

    fun handleSuccess() {
        resetData();
        Handler(Looper.getMainLooper()).post {
            findNavController().popBackStack()
            Toast.makeText(context, "Vaga reservada com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }

    fun handleError(message: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }

}