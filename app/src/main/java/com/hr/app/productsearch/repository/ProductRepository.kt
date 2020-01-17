package com.hr.app.productsearch.repository

import androidx.lifecycle.MutableLiveData
import com.hr.app.productsearch.model.Product
import com.hr.app.productsearch.network.NetworkManager
import com.hr.app.productsearch.network.response.ProductScannedResponse
import com.hr.app.productsearch.network.services.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ProductRepository {
    private var productsLiveData: MutableLiveData<List<Product>> = MutableLiveData()
    private var productService: ProductService? = NetworkManager.getRetrofit()?.create(ProductService::class.java)



    public fun getProduct(barcode: String): MutableLiveData<List<Product>> {
        val call: Call<ProductScannedResponse>? = productService?.getProduct(barcode)

        call?.enqueue(object : Callback<ProductScannedResponse> {
            override fun onResponse(call: Call<ProductScannedResponse>?, response: Response<ProductScannedResponse>?) {
                if (response?.code() == 200) {
                    val productResponseBody = response.body()!!
                    productsLiveData.postValue(listOf(productResponseBody.product))
                    // println(productResponseBody)
                }
            }

            override fun onFailure(call: Call<ProductScannedResponse>?, t: Throwable?) {
                println(t?.message)
            }
        })

        return productsLiveData
    }
}