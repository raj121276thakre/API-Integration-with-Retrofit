package com.example.apiapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapp.adapter.MyAdapter
import com.example.apiapp.model.MyData
import com.example.apiapp.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)

        //step-4 Retrofit Builder
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/") //add the url of API without the endpoint
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)// interface class


        //step-5 Api Call
        val retrofitData = retrofitBuilder.getProductData()

        //after enqueue(CTRL+SHIFT+SPACE) ->  to generate below code
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //if Api call is success, then use the data of Api and show in your app
                var responseBody = response.body()
                val productList = responseBody?.products!!

                myAdapter = MyAdapter(this@MainActivity, productList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)



            }
            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                //if api call fails
                Toast.makeText(this@MainActivity,"Failed to get Data from api....",Toast.LENGTH_SHORT).show()

            }
        })



    }


}

















