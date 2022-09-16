package com.iittii.task5.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.iittii.task5.databinding.ActivityFilmeBinding
import com.iittii.task5.model.Results
import com.iittii.task5.util.Constants.BASE_IMAGE
import com.squareup.picasso.Picasso

class rcadaptar(private val movieList: Array<Results>, private val movieInterface: MovieInterface) : RecyclerView.Adapter<rcadaptar.filmVH>() {

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
        holder.ivfilme?.let {
            Picasso.get().load(BASE_IMAGE + movieList[position].poster_path).into(it)
            it.setOnClickListener {
                movieInterface.onClick(movieList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}