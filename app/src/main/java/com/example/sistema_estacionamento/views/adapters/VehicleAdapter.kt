package com.example.sistema_estacionamento.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.models.VehicleModel

class VehicleAdapter(private val vehicles: List<VehicleModel>): RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val plateTextView: TextView = itemView.findViewById(R.id.textview_park_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vehicle_viewholder, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicles[position]
        holder.plateTextView.text = vehicle.plate
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }
}