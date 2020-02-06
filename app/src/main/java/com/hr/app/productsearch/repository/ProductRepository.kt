package com.hr.app.productsearch.repository

import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.hr.app.productsearch.R
import com.hr.app.productsearch.model.Product
import com.hr.app.productsearch.network.NetworkManager
import com.hr.app.productsearch.network.response.ProductScannedResponse
import com.hr.app.productsearch.network.response.ProductSearchResponse
import com.hr.app.productsearch.network.services.ProductService
import com.hr.app.productsearch.utils.Utils
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ProductRepository {
    private const val SEARCH_SIMPLE: String = "1"
    private const val ACTION: String = "process"
    private const val JSON: String = "1"

    var searchValue: String = ""
    var scannedValue: String = ""

    var productsLiveData: MutableLiveData<List<Product>> = MutableLiveData()
    var productService: ProductService? = NetworkManager.getRetrofit()?.create(ProductService::class.java)

    // Find products by search
    public fun getProducts(): MutableLiveData<List<Product>> {
        val call: Call<ProductSearchResponse>? = productService?.getProducts(searchValue, SEARCH_SIMPLE, ACTION, JSON)

        call?.enqueue(object : Callback<ProductSearchResponse> {
            override fun onResponse(call: Call<ProductSearchResponse>?, response: Response<ProductSearchResponse>?) {
                if (response?.code() == 200) {
                    val productResponseBody = response.body()!!
                    println(productResponseBody)
                    productsLiveData.postValue(productResponseBody.products)
                }
            }

            override fun onFailure(call: Call<ProductSearchResponse>?, t: Throwable?) {
                println(t?.message)
            }
        })

        return productsLiveData
    }

    // Find product by scanning a barcode
    public fun getProduct(): MutableLiveData<List<Product>> {
        val call: Call<ProductScannedResponse>? = productService?.getProduct(scannedValue)

        call?.enqueue(object : Callback<ProductScannedResponse> {
            override fun onResponse(call: Call<ProductScannedResponse>?, response: Response<ProductScannedResponse>?) {
                if (response?.code() == 200) {
                    val productResponseBody = response.body()!!
                    println(productResponseBody)
                    if (productResponseBody.status == 0) {
                        return
                    }
                    productsLiveData.postValue(listOf(productResponseBody.product))
                }
            }

            override fun onFailure(call: Call<ProductScannedResponse>?, t: Throwable?) {
                println(t?.message)
            }
        })

        return productsLiveData
    }

    // Get specific product by id
    public fun getProductById(id: String): Product? {
        for (product in productsLiveData.value!!.iterator()) {
            if (product.id.equals(id)) {
                return product
            }
        }
        return null
    }
}