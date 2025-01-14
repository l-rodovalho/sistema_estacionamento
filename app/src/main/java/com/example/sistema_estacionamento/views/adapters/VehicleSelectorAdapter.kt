package com.example.sistema_estacionamento.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.models.VehicleModel

class VehicleSelectorAdapter(private val vehicles: List<VehicleModel>, private val handleSelectVehicle: (plate: String) -> Unit): RecyclerView.Adapter<VehicleSelectorAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val plate: TextView = itemView.findViewById(R.id.btn_vehicle_selector_plate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vehicle_selector_viewholder, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicles[position]
        holder.plate.text = vehicle.plate
        holder.plate.setOnClickListener { handleSelectVehicle(vehicle.plate) }
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }
}