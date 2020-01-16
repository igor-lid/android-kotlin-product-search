package com.hr.app.productsearch.screen.Login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hr.app.productsearch.R
import com.hr.app.productsearch.network.NetworkManager
import com.hr.app.productsearch.network.response.ProductScannedResponse
import com.hr.app.productsearch.network.services.ProductService
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
        val productService: ProductService? = NetworkManager.getRetrofit()?.create(ProductService::class.java)
        var call: Call<ProductScannedResponse>? = productService?.getProduct("737628064502")

        call?.enqueue(object : Callback<ProductScannedResponse> {
            override fun onResponse(call: Call<ProductScannedResponse>?, response: Response<ProductScannedResponse>?) {
                if (response?.code() == 200) {
                    val productResponseBody = response.body()!!
                    println(productResponseBody)
                }
            }

            override fun onFailure(call: Call<ProductScannedResponse>?, t: Throwable?) {
                println(t?.message)
            }
        })
    }
}