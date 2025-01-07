package com.example.sistema_estacionamento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private val carros: List<Carro>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val modeloTextView: TextView = itemView.findViewById(R.id.textView11)
        val placaTextView: TextView = itemView.findViewById(R.id.textView12)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_list, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val carro = carros[position]
        holder.modeloTextView.text = carro.modelo
        holder.placaTextView.text = carro.placa
    }

    override fun getItemCount(): Int {
        return carros.size
    }
}