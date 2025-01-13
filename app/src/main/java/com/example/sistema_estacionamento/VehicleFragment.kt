package com.example.sistema_estacionamento

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.databinding.FragmentParksBinding
import com.example.sistema_estacionamento.databinding.FragmentVehicleBinding
import com.example.sistema_estacionamento.views.adapters.VehicleAdapter

class VehicleFragment : Fragment() {

    private lateinit var binding: FragmentVehicleBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVehicleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        renderUserData();

        renderVehicles()

        registerEvents()
    }

    fun renderUserData() {
        binding.textviewUserName.text = MainActivity.currentUser?.name as String
    }

    fun registerEvents() {
        binding.btnNavigationParks.setOnClickListener {handleGoToParks()}
        binding.btnNewVehicle.setOnClickListener {handleGoToNewVehicle()}
    }

    fun handleGoToParks() {
        findNavController().navigate(R.id.action_vehicleFragment_to_parksFragment)
    }

    fun handleGoToNewVehicle() {

    }

    fun clearVehicles() {
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
//        recyclerView.layoutManager = LinearLayoutManager(this);
//        recyclerView.adapter = VehicleAdapter(emptyList());
    }

    fun renderVehicles() {
        clearVehicles();
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
//        recyclerView.layoutManager = LinearLayoutManager(this);
//        Log.d("VEHICLES", MainActivity.vehicles.toString());
//        recyclerView.adapter = VehicleAdapter(MainActivity.vehicles);
    }
}