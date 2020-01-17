package com.hr.app.productsearch.model

import com.google.gson.annotations.SerializedName

data class ProductNutriments (
    @SerializedName("proteins_100g")
    val proteins100g: Double?,

    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Double?,

    @SerializedName("fat_100g")
    val fat100g: Double?,

    @SerializedName("energy_value")
    val energyKcal100g: Double?,

    @SerializedName("energy")
    val energy: Double?
)