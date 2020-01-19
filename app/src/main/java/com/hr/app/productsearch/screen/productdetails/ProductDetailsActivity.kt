package com.hr.app.productsearch.screen.productdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hr.app.productsearch.R

class ProductDetailsActivity : AppCompatActivity() {
    companion object {
        // when searching
        fun start(context: Context?, productId: String?) {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("PRODUCT_ID", productId)
            context?.startActivity(intent)
        }

        // when scanning
        fun start(context: Context) {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        // Hide action bar
        if (supportActionBar != null) supportActionBar?.hide()

        val productId: String = intent.getStringExtra("PRODUCT_ID")
        supportFragmentManager
            .beginTransaction()
            .add(R.id.activityProductDetailsLayout, ProductDetailsFragment.instance(productId), "product-details")
            .commit()
    }
}