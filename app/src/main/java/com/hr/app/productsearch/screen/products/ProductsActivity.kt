package com.hr.app.productsearch.screen.products

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hr.app.productsearch.R

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Hide action bar
        if (supportActionBar != null) supportActionBar?.hide()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.activityProductsLayout, ProductFragment(), "products")
            .commit()
    }
}