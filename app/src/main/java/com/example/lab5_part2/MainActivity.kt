package com.example.lab5_part2
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val products = ArrayList<Product>()
    private val cart = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add sample product data
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0, R.drawable.ipad))
        products.add(Product("Iphone", "8GB RAM", 1000.0, R.drawable.iphone))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.0, R.drawable.laptop))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.0, R.drawable.keybpard))

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = ProductAdapter(products) { product ->
            addToCart(product)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val viewCartButton: View = findViewById(R.id.viewCartButton)
        viewCartButton.setOnClickListener {
            // Show the cart content as a Toast
            val cartItems = cart.joinToString("\n") { "${it.productName} - $${it.cost}" }
            val message = if (cartItems.isEmpty()) "Your cart is empty." else "Items in the cart:\n$cartItems"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }

    // Create a function to add a product to the cart
    private fun addToCart(product: Product) {
        cart.add(product)
    }
}
