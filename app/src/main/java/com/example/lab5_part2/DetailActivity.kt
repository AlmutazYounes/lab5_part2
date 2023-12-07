package com.example.lab5_part2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent.hasExtra("image") && intent.hasExtra("name") && intent.hasExtra("detail")) {
            var image = intent.getIntExtra("image", 0)
            var name = intent.getStringExtra("name")
            var x = intent.getStringExtra("detail")

            var item2 = findViewById<TextView>(R.id.item2)
            var info = findViewById<TextView>(R.id.info)
            var image4 = findViewById<ImageView>(R.id.image4)

            item2.text = name.toString()
            info.text = x.toString()
            image4.setImageResource(image)
        }
    }
}