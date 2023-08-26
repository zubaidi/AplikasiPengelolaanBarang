package com.codepelita.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codepelita.myapplication.databinding.BarangAdapterBinding
import com.codepelita.myapplication.db.BarangModel

class AdapterBarang(val barangList: ArrayList<BarangModel>) : RecyclerView.Adapter<AdapterBarang.BarangHolder>() {
    class BarangHolder(val binding: BarangAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangHolder {
        return BarangHolder(
            BarangAdapterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BarangHolder, position: Int) {
        with(holder) {
            with(barangList[position]) {
                binding.txtDataKode.text = this.kodeBarang.toString()
                binding.txtDataNamaBarang.text = this.namaBarang
                binding.txtDataHargaBarang.text = this.hargaBeli.toString()
                binding.txtDataStok.text = this.stokBarang.toString()
            }
        }
    }

    override fun getItemCount() = barangList.size

    fun setData(list: List<BarangModel>) {
        barangList.clear()
        barangList.addAll(list)
    }
}