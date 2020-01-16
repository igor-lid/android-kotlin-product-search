package com.hr.app.productsearch.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private const val BASE_URL: String = "https://world.openfoodfacts.org/"
    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(provideConverterFactory())
            .build()
    }

    public fun getRetrofit(): Retrofit? {
        return retrofit
    }

    private fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}