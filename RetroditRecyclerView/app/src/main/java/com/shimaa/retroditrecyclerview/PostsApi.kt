package com.shimaa.retroditrecyclerview


import okhttp3.ResponseBody
import retrofit2.http.GET


interface PostsApi {

    @GET("posts")
    fun getposts():retrofit2.Call<List<posts>>

}

