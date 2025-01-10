package com.example.sistema_estacionamento.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_estacionamento.R
import com.example.sistema_estacionamento.models.ParkModel

class ParkAdapter (private val parks: List<ParkModel>): RecyclerView.Adapter<ParkAdapter.ParkViewHolder>(){

    class ParkViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textview_park_name)
        val statusTextView: TextView = itemView.findViewById(R.id.textview_park_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_park, parent, false)
        return ParkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        val park = parks[position];
        holder.nameTextView.text = park.name;
        holder.statusTextView.text = "Disponível";
    }

    override fun getItemCount(): Int {
        return parks.size
    }
}