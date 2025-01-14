package com.example.sistema_estacionamento

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sistema_estacionamento.controllers.ParkController
import com.example.sistema_estacionamento.databinding.FragmentParksBinding
import com.example.sistema_estacionamento.models.ParkModel
import com.example.sistema_estacionamento.views.adapters.ParkAdapter

class ParksFragment : Fragment() {

    private lateinit var binding: FragmentParksBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParksBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        renderUserData()

        registerEvents()

        loadParks()
    }

    fun renderUserData() {
        if (MainActivity.currentUser?.name != null) {
            binding.textviewUserName.text = MainActivity.currentUser?.name as String
        }
    }

    fun registerEvents() {
        binding.btnNavigationVehicles.setOnClickListener {handleGoToVehicles()}
        binding.btnParksQuit.setOnClickListener {handleQuit()}
    }

    private fun handleQuit() {
        val sharedPref = MainActivity.instance?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            remove("accessToken")
        }
        MainActivity.currentUser = null;
        MainActivity.vehicles = emptyList();

        findNavController().navigate(R.id.action_parksFragment_to_signInFragment)
    }

    fun handleGoToVehicles() {
        findNavController().navigate(R.id.action_parksFragment_to_vehicleFragment)
    }

    fun loadParks() {
        ParkController.getParks(MainActivity.currentUser?.accessToken as String, ::handleErrorParks, ::handleSuccessParks);
    }

    fun handleSuccessParks(parks: List<ParkModel>) {
       // val recyclerView = binding.recyclerView;
        //recyclerView.layoutManager = LinearLayoutManager(context);

        //recyclerView.adapter = ParkAdapter(parks);
    }

    fun handleErrorParks() {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(MainActivity.instance, "Ops... Ocorreu um erro", Toast.LENGTH_LONG).show();
        }
    }

}