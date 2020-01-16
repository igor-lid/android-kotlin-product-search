package com.hr.app.productsearch.network.response

import com.google.gson.annotations.SerializedName
import com.hr.app.productsearch.model.Product

data class ProductScannedResponse (
    @SerializedName("status_verbose")
    val statusVerbose: String,

    val status: Int,
    val code: String,
    val product: Product
)