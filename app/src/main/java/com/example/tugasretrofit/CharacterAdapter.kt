package com.example.tugasretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasretrofit.databinding.ItemCharacterBinding

class CharacterAdapter(private val dataCharacter: List<ResultsItem?>?) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){

        //menyimpan referensi ke elemen tampilan setiap item
        inner class ViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
            val imgCharacter = binding.itemImageCharacter
            val nameCharacter = binding.itemNameCharacter
            val statusCharacter = binding.itemStatusCharacter
            val speciesCharacter = binding.itemSpeciesCharacter
        }

    //membuat ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    //return jumlah total item dalam dataCharacter
    override fun getItemCount(): Int {
        if (dataCharacter != null){
            return dataCharacter.size
        }
        return 0
    }

    //menetapkan data ke ViewHolder pada posisi tertentu
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nameCharacter.text = dataCharacter?.get(position)?.name
        holder.statusCharacter.text = dataCharacter?.get(position)?.status
        holder.speciesCharacter.text = dataCharacter?.get(position)?.species

        //memuat gambar dari URL ke ImageView
        Glide.with(holder.imgCharacter)
            .load(dataCharacter?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgCharacter)
    }
}