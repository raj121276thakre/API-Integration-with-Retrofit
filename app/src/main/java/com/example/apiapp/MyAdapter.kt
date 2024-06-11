package com.example.apiapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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

    }


}














