package com.example.myapplication.service

import com.example.myapplication.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostAPI {

    @GET("posts")
    fun getAllPosts(): Call<ArrayList<Post>>
}