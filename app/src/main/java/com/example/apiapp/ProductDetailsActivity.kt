package com.example.apiapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apiapp.databinding.ActivityProductDetailsBinding
import com.example.apiapp.model.Product
import com.squareup.picasso.Picasso

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainProduct)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title = intent.getStringExtra("TITLE")
        val description = intent.getStringExtra("DESCRIPTION")
        val price = intent.getDoubleExtra("PRICE", 0.0)
        val rating = intent.getDoubleExtra("RATING", 0.0)
        val thumbnail = intent.getStringExtra("THUMBNAIL")

        binding.productTitle.text = title
        binding.productDescription.text = description
        binding.productPrice.text = "Price: $${price}"
        binding.productRating.text = "Rating: ${rating}"
        Picasso.get().load(thumbnail).into(binding.productThumbnail)


    }



}