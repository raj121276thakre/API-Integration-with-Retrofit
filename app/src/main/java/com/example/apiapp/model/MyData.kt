package com.example.apiapp.model
//step-2 model class
data class MyData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)