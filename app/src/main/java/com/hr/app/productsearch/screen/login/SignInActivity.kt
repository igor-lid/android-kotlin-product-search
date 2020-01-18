package com.hr.app.productsearch.screen.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hr.app.productsearch.R
import com.hr.app.productsearch.repository.ProductRepository

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Hide action bar
        if (supportActionBar != null) supportActionBar?.hide()

        // TESTING
        println(ProductRepository.getProduct("737628064502"))
    }
}