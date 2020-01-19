package com.hr.app.productsearch.screen.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hr.app.productsearch.model.Product
import com.hr.app.productsearch.repository.ProductRepository

class ProductsViewModel : ViewModel() {

    fun getProducts(): LiveData<List<Product>> {
        return ProductRepository.getProducts()
    }
}