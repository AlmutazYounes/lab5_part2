package com.example.lab5_part2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getSerializableExtra("productDetails") as Product

        val productImage = findViewById<ImageView>(R.id.productImage)
        val productName = findViewById<TextView>(R.id.productName)
        val productDescription = findViewById<TextView>(R.id.productDescription)
        val productCost = findViewById<TextView>(R.id.productCost)

        productImage.setImageResource(product.imageResourceId)
        productName.text = product.productName
        productDescription.text = product.description
        productCost.text = "$${product.cost}"
    }
}
