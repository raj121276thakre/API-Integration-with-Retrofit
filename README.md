Step 1 : Add Retrofit Dependency: Add Retrofit and Gson converter dependencies to your 
         build.gradle file.
    
        implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        implementation 'com.squareup.retrofit2:converter-gson:2.9.0'


Step 2 : Add Internet permission in AndroidManifest.xml
         
            <uses-permission android:name="android.permission.INTERNET" />


Step 3 : Create Data Model: Define data classes that represent the JSON response from the
         API.

package com.example.apiapp.model

data class Product(
    val availabilityStatus: String,
    val brand: String,
    val category: String,
    val description: String,
    val dimensions: Dimensions,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val meta: Meta,
    val minimumOrderQuantity: Int,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
    val reviews: List<Review>,
    val shippingInformation: String,
    val sku: String,
    val stock: Int,
    val tags: List<String>,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
    val weight: Int
)

Step 4 : Create Retrofit Interface: Define an interface that specifies the API endpoints.

  interface ApiInterface {

    @GET("products") //write endpoint of Api
    fun getProductData() : Call<MyData>

}


Step 5 : Create Retrofit Instance: Create a Retrofit instance using the Retrofit builder in                
         MainActivity and specify the base URL.

          val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/") //add the url of API without the endpoint
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)// interface class

       
Step 6 : Make API Call: Use the Retrofit interface to make API calls from your activity or fragment.

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


            }
        })




























