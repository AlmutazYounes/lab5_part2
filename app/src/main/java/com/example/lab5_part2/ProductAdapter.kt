package com.example.lab5_part2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: List<Product>, private val addToCartClickListener: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.productName.text = product.productName
        holder.productDescription.text = product.description
        holder.productCost.text = "$${product.cost}"

        // Set the product image using the image resource ID
        holder.productImage.setImageResource(product.imageResourceId)

        holder.addToCartButton.setOnClickListener {
            addToCartClickListener?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productLogo: ImageView = itemView.findViewById(R.id.productLogo)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productDescription: TextView = itemView.findViewById(R.id.productDescription)
        val productCost: TextView = itemView.findViewById(R.id.productCost)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
    }
}