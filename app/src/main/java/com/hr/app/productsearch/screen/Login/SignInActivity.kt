package com.hr.app.productsearch.screen.Login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hr.app.productsearch.R
import com.hr.app.productsearch.network.NetworkManager
import com.hr.app.productsearch.network.response.ProductScannedResponse
import com.hr.app.productsearch.network.services.ProductService
import com.hr.app.productsearch.repository.ProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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