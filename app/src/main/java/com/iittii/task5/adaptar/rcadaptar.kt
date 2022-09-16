package com.iittii.task5.adaptar

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.iittii.task5.databinding.ActivityFilmeBinding

class rcadaptar(private val imageList: List<Int>) : RecyclerView.Adapter<rcadaptar.filmVH>() {

    inner class filmVH(itemview: ActivityFilmeBinding) : RecyclerView.ViewHolder(itemview.root) {
        var ivfilme: ImageView? = null

        init {
            ivfilme = itemview.imview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): filmVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityFilmeBinding.inflate(inflater)
        return filmVH(binding)
    }

    override fun onBindViewHolder(holder: filmVH, position: Int) {
        holder.ivfilme?.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }


}