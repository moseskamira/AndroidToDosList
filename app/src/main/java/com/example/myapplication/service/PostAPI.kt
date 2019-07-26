package com.example.myapplication.service

import com.example.myapplication.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import kotlin.collections.ArrayList

interface PostAPI {

    @GET("posts")
    fun getAllPosts(): Observable<ArrayList<Post>>
}