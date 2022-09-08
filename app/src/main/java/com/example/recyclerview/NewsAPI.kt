package com.example.recyclerview
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPI {
    @GET("v2/everything")

    fun everything(@Query("q") query: String,@Query("apiKey") apiKey: String):Call<Everything>


}

var retrofit = Retrofit.Builder()
    .baseUrl("https://newsapi.org")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var service: NewsAPI = retrofit.create(NewsAPI::class.java)