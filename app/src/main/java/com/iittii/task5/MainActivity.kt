package com.iittii.task5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.iittii.task5.adaptar.MovieInterface
import com.iittii.task5.adaptar.rcadaptar
import com.iittii.task5.databinding.ActivityMainBinding
import com.iittii.task5.datasource.remote.RetrofitConfig
import com.iittii.task5.model.Filmresponse
import com.iittii.task5.model.Results
import com.iittii.task5.util.Constants
import com.iittii.task5.util.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MovieInterface {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecycleViewer()
    }

    override fun onStart() {
        super.onStart()
        RetrofitConfig.getServiceInstance().fetchFilme(Constants.API_KEY).enqueue(object :
            Callback<Filmresponse> {
            override fun onResponse(call: Call<Filmresponse>, response: Response<Filmresponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        viewFilm(it)
                    }
                }
            }

            override fun onFailure(call: Call<Filmresponse>, t: Throwable) {
                t.message?.let {
                    showToast(it)
                }
            }
        })
    }

    private fun viewFilm(films: Filmresponse) {
        binding.rcview.adapter = rcadaptar(films.results, this)
    }


    fun setUpRecycleViewer() {
        binding.rcview.layoutManager = GridLayoutManager(this, 3)
    }

    override fun onClick(movie: Results) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra(Constants.IMAGE_URL, Constants.BASE_IMAGE + movie.backdrop_path)
        intent.putExtra(Constants.TITLE, movie.title)
        intent.putExtra(Constants.VOTE, movie.vote_average.toString())
        startActivity(intent)
    }
}