package com.example.myapplication.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostService {
    private val baseUrl = "https://jsonplaceholder.typicode.com/"
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory
        .create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

    fun getRetrofit(): PostAPI? {
        return retrofit.create(PostAPI::class.java)
    }
}