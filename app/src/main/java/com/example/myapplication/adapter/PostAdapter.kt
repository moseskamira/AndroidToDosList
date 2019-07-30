package com.example.myapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.model.Post
import kotlinx.android.synthetic.main.item_list_view.view.*

class PostAdapter(val context: Context, private val availablePosts: ArrayList<Post>):
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R
            .layout.item_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return availablePosts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postId.text = availablePosts[position].id.toString()
        holder.title.text = availablePosts[position].title
        holder.body.text = availablePosts[position].body
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var postId = itemView.post_id!!
        var title = itemView.title_id!!
        var body = itemView.body_id!!
    }
}