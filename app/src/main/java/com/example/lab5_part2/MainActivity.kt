package com.example.lab5_part2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import MyAdapter
import Product
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView // Declare recyclerView here
    private val cart: MutableList<Product> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recylerview) // Initialize it after setContentView

        var image = intArrayOf(
            R.drawable.apple,
            R.drawable.dell,
            R.drawable.keybpard,
            R.drawable.ipad,
            R.drawable.iphone
        )
        val x=getResources().getStringArray(R.array.detail)
        val product = ArrayList<Product>()
        product.add(Product("apple",x[0],image[0]))
        product.add(Product("dell",x[1],image[1]))
        product.add(Product("keyboard",x[2],image[2]))
        product.add(Product("ipad",x[3],image[3]))
        product.add(Product("iphone",x[4],image[4]))
        // Set the Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this,product, this::addToCart)
        // Set adapter to your RecyclerView
        recyclerView.adapter = adapter


        val showCartButton: Button = findViewById(R.id.showCartButton)
        showCartButton.setOnClickListener {
            showCart()
        }
    }
    private fun addToCart(product: Product) {
        // Add the product to the cart and maybe update the UI
        cart.add(product)
        Toast.makeText(this, "${product.productName} added to cart", Toast.LENGTH_SHORT).show()
    }
    private fun showCart() {
        val cartItems = cart.joinToString(separator = "\n") { it.productName }
        val dialog = AlertDialog.Builder(this)
            .setTitle("Cart Items")
            .setMessage(cartItems)
            .setPositiveButton("Close", null)
            .create()
        dialog.show()
    }

}