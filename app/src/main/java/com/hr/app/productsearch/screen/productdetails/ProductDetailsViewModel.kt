package com.hr.app.productsearch.screen.productdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hr.app.productsearch.model.Product
import com.hr.app.productsearch.repository.ProductRepository

class ProductDetailsViewModel : ViewModel() {
    fun getProduct(productId: String): MutableLiveData<Product> {
        val product: Product? = ProductRepository.getProductById(productId)
        val productLiveData: MutableLiveData<Product> = MutableLiveData()

        productLiveData.value = product

        return productLiveData
    }

    fun getProduct(): MutableLiveData<List<Product>> {
        return ProductRepository.getProduct()
    }
}