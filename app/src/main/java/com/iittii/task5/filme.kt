package com.iittii.task5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iittii.task5.databinding.ActivityFilmeBinding

class filme : AppCompatActivity() {
    private lateinit var binding: ActivityFilmeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}