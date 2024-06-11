package com.example.apiapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapp.ProductDetailsActivity
import com.example.apiapp.R
import com.example.apiapp.model.Product
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView
        lateinit var id: TextView
        lateinit var image: ImageView
        lateinit var description: TextView
        lateinit var price: TextView
        lateinit var rating: TextView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productThumbnail)
            description = itemView.findViewById(R.id.productDescription)
            price = itemView.findViewById(R.id.productPrice)
            rating = itemView.findViewById(R.id.productRating)
            id = itemView.findViewById(R.id.productId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.product_item, parent,false )
         return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productArrayList[position] // current data
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.price.text =  "Price: $${currentItem.price.toString()}"
        holder.rating.text = "Rating: ${currentItem.rating.toString()}"
        holder.id.text = "Item: ${currentItem.id.toString()}"

        //imageview
        Picasso.get().load(currentItem.thumbnail).into(holder.image)


        // Set click listener for the item view
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("TITLE", currentItem.title)
            intent.putExtra("DESCRIPTION", currentItem.description)
            intent.putExtra("PRICE", currentItem.price)
            intent.putExtra("RATING", currentItem.rating)
            intent.putExtra("THUMBNAIL", currentItem.thumbnail)
            // Add more fields as needed
            context.startActivity(intent)
        }

    }


}














