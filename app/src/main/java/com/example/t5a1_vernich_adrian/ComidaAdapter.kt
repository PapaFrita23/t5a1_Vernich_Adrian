package com.example.t5a1_vernich_adrian

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.t5a1_vernich_adrian.databinding.ItemUserBinding

class ComidaAdapter (private val comidas: List<Comida>, private val listener: OnClickListener): RecyclerView.Adapter<ComidaAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //Inflar la vista en el recycler
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = comidas.get(position)

        with(holder) {
            setListener(user)
            binding.tvOrder.text = (position + 1).toString()
            binding.tvName.text = user.getFullName()
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)
        }
    }

    override fun getItemCount(): Int {
        return comidas.size
    }

    inner  class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemUserBinding.bind(view) //Vinculamos la vista a nuestro adapter

        fun setListener(comida: Comida) {
            binding.root.setOnClickListener {
                listener.onClick(comida)
            }
        }
    }
}