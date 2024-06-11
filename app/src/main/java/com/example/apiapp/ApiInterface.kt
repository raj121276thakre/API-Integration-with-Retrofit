package com.example.apiapp

import com.example.apiapp.model.MyData
import retrofit2.Call
import retrofit2.http.GET

//step-3 Api Interface
interface ApiInterface {

    @GET("products") //write endpoint of Api
    fun getProductData() : Call<MyData>


}