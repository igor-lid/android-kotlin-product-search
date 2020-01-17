package com.hr.app.productsearch.model

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("image_front_url")
    val imageFrontUrl: String?,

    @SerializedName("image_nutrition_url")
    val imageNutritionUrl: String?,

    @SerializedName("product_name")
    val productName: String?,

    val brands: String?,
    val quantity: String?,

    val nutriments: ProductNutriments?
)