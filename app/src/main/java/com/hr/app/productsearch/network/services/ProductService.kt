package com.hr.app.productsearch.network.services

import com.hr.app.productsearch.network.response.ProductScannedResponse
import com.hr.app.productsearch.network.response.ProductSearchResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    companion object {
        private const val USER_AGENT: String = "UserAgent: ProductSearchApp - Android - Version 1.0"
    }

    // Get products by search
    // e.g. https://world.openfoodfacts.org/cgi/search.pl?search_terms=cocacola&search_simple=1&action=process&json=1
    @Headers(USER_AGENT)
    @GET("cgi/search.pl")
    fun getProducts(
        @Query("search_terms") searchTerms: String,
        @Query("search_simple") searchSimple:String,
        @Query("action") action: String,
        @Query("json") json: String): retrofit2.Call<ProductSearchResponse>

    // Get product by scanning barcode
    // e.g. https://world.openfoodfacts.org/api/v0/product/737628064502.json
    @Headers(USER_AGENT)
    @GET("api/v0/product/{barcode}.json")
    fun getProduct(
        @Path("barcode") barcode: String): retrofit2.Call<ProductScannedResponse>
}