package com.iittii.task5.datasource.remote

import com.iittii.task5.model.Filmresponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("popular")
    fun fetchFilme(@Query("api_key")key:String):Call<Filmresponse>
}