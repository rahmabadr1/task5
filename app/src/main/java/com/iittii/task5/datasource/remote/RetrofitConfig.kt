package com.iittii.task5.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.create
import retrofit2.create

object RetrofitConfig {
  private  fun getRetrofitInstance():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/").addConverterFactory(GsonConverterFactory.create()).build()

    }
    fun getServiceInstance():ApiService{
      return  getRetrofitInstance().create<ApiService>()
    }
}


