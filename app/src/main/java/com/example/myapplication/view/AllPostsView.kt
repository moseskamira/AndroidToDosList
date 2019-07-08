package com.example.myapplication.view

import com.example.myapplication.model.Post

interface AllPostsView {
    fun displayAllPosts(response: ArrayList<Post>)
}