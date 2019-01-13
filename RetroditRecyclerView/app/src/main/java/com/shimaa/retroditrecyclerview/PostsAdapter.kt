package com.shimaa.retroditrecyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PostsAdapter(var Posts: List<posts> = ArrayList()) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder{
        var row:View =LayoutInflater.from(parent.context).inflate(R.layout.post_row,parent,false)
        Log.d("ADAPTER", Posts.size.toString())
        var holder:PostsViewHolder= PostsViewHolder(row)
        return holder
    }

     override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
         var post: posts = Posts[position]
         holder.title.text = post.getTitle()
    }

     override fun getItemCount(): Int {
         return Posts.size
    }

    class PostsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView!!.findViewById(R.id.postTitle)
    }

}




