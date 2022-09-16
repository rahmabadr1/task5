package com.iittii.task5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iittii.task5.databinding.ActivityDetailsBinding
import com.iittii.task5.util.Constants
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            val imageUrl = it.getString(Constants.IMAGE_URL, "")
            val title = it.getString(Constants.TITLE, "")
            val vote = it.getString(Constants.VOTE, "")

            Picasso.get().load(imageUrl).into(binding.iv)
            binding.tvTitle.text = title
            binding.tvVote.text = vote

        }
    }
}