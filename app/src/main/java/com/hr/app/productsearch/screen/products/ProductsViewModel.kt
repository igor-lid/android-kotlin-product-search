package com.hr.app.productsearch.screen.products

import androidx.lifecycle.ViewModel
import com.hr.app.productsearch.repository.ProductRepository

class ProductsViewModel : ViewModel() {
    private val productRepository: ProductRepository = ProductRepository
}