package com.shimaa.retroditrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "     Posts"

        var posts :List<posts> =  ArrayList()
        lateinit var recyclerView:RecyclerView
        var retrofit = Retrofit.Builder()
                .addConverterFactory(
                        GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()

        var api = retrofit.create(PostsApi::class.java)

        var connection = api.getposts()
        connection.enqueue(object : Callback<List<posts>> {
            override fun onFailure(call: Call<List<posts>>?, t: Throwable?) {
                Log.d("RESULT","FAILD")

            }
            override fun onResponse(call: Call<List<posts>>?, response: Response<List<posts>>?) {
                posts = response!!.body()
                //Log.d("RESULT", posts!![0].getTitle())
                recyclerView=findViewById(R.id.recyclerView)
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                var adapter=PostsAdapter(posts)
                recyclerView.adapter=adapter
            }
        })



    }
}
/*

onResponse berun in background
kan fe mo4kla f ResponseResult el class l2n el object kan asmo 0,1,2, m4 asmhom posts 5als
el view holder el mafroud yb2a gwa el adapter 3ady



 */


