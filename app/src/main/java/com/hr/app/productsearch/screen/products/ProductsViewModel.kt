package com.hr.app.productsearch.screen.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hr.app.productsearch.model.Product
import com.hr.app.productsearch.repository.ProductRepository

class ProductsViewModel : ViewModel() {
//    private val productRepository: ProductRepository = ProductRepository

    fun getProducts(): LiveData<List<Product>> {
        // TEST
        val products: MutableLiveData<List<Product>> = ProductRepository.getProducts()
        println("[PRODUCTS VIEW MODEL]")
        println(products.value)
        return products
//        return productRepository.getProducts()
    }
}