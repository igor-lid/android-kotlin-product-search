package com.hr.app.productsearch.network.response

import com.google.gson.annotations.SerializedName
import com.hr.app.productsearch.model.Product

data class ProductSearchResponse (
    @SerializedName("page_size")
    val pageSize: String,

    val count: Int,
    val page: String,
    val skip: Int,

    val products: List<Product>
)