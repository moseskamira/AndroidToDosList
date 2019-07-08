package com.example.myapplication.presenter

import com.example.myapplication.model.Post
import com.example.myapplication.service.PostAPI
import com.example.myapplication.service.PostService
import com.example.myapplication.view.AllPostsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostPresenter {
    var postApiInterface: PostAPI = PostService().getRetrofit()

    fun presentAllPosts(allPostsView: AllPostsView){
        postApiInterface.getAllPosts().enqueue(object: Callback<ArrayList<Post>> {

            override fun onResponse(call: Call<ArrayList<Post>>?, response: Response<ArrayList<Post>>?) {
                if (response!!.body() != null) {
                    allPostsView.displayAllPosts(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created File Templates.
            }
        })
    }

}