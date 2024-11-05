package com.example.list

import Disaster
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.ItemDisasterBinding

typealias OnClickDisaster = (Disaster) -> Unit

class DisasterAdapter(
    private val listDisaster: List<Disaster>,
    private val onClickDisaster: OnClickDisaster
) : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Disaster) {
            with(binding) {
                tvDisasterName.text = data.nameDisaster
                tvDisasterType.text = data.disasterType

                // Memuat gambar dari resource lokal
                ivDisasterImage.setImageResource(data.imageResId)

                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDisaster.size
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}

