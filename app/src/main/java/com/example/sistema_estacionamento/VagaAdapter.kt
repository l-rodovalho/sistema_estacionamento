package com.example.sistema_estacionamento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VagaAdapter(private val vagas: List<Vaga>) : RecyclerView.Adapter<VagaAdapter.VagaViewHolder>() {

    class VagaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vagaTextView: TextView = itemView.findViewById(R.id.textView11)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_list, parent, false)
        return VagaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VagaViewHolder, position: Int) {
        val vaga = vagas[position]
        holder.vagaTextView.text = vaga.nome
    }

    override fun getItemCount(): Int {
        return vagas.size
    }
}