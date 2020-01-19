package com.hr.app.productsearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hr.app.productsearch.screen.products.ProductsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide action bar
        if (supportActionBar != null) supportActionBar?.hide()

        // TEST
        search_button.setOnClickListener {
            val intent = Intent(it.context, ProductsActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}
