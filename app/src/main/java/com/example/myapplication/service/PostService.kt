package com.example.myapplication.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostService {
    val baseUrl = "https://jsonplaceholder.typicode.com/"
    var retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    fun getRetrofit(): PostAPI {
//        val baseUrl = "https://jsonplaceholder.typicode.com/"
//        if (retrofit != null) {
//            retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
//        }
        return retrofit.create(PostAPI::class.java)

    }
}