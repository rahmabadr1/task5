package com.iittii.task5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iittii.task5.adaptar.rcadaptar
import com.iittii.task5.databinding.ActivityMainBinding
import com.iittii.task5.datasource.remote.RetrofitConfig
import com.iittii.task5.model.Filmresponse
import com.iittii.task5.util.Constants
import com.iittii.task5.util.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecycleViewer()
    }

    override fun onStart() {
        super.onStart()
        RetrofitConfig.getServiceInstance().fetchFilme(Constants.API_KEY).enqueue(object :
            Callback<Filmresponse> {
            override fun onResponse(call: Call<Filmresponse>, response: Response<Filmresponse>) {
                if(response.isSuccessful){
                    response.body()?.let { 
                        viewFilme(it)
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

    private fun viewFilme(it: Filmresponse) {

    }


    fun setUpRecycleViewer() {
        binding.rcview.layoutManager = GridLayoutManager(this,3)

    }


}