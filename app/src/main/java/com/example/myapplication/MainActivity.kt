package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.myapplication.adapter.PostAdapter
import com.example.myapplication.model.Post
import com.example.myapplication.presenter.PostPresenter
import com.example.myapplication.view.AllPostsView

class MainActivity : AppCompatActivity(), AllPostsView {
    lateinit var recyclerView: RecyclerView
    lateinit var presenter: PostPresenter
    lateinit var availablePosts: ArrayList<Post>
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var postAdapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = PostPresenter()
        layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recycler_view1)
        recyclerView.layoutManager = layoutManager

        loadPosts()

    }
    override fun displayAllPosts(response: ArrayList<Post>) {
        availablePosts = ArrayList(response)
        postAdapter = PostAdapter(this, availablePosts)
        recyclerView.adapter = postAdapter

    }
    private fun loadPosts(){
        presenter.presentAllPosts(this)
    }
}
