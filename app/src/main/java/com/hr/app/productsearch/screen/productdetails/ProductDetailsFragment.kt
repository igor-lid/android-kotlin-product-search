package com.hr.app.productsearch.screen.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.hr.app.productsearch.R
import com.hr.app.productsearch.model.Product
import kotlinx.android.synthetic.main.fragment_product_details.*

class ProductDetailsFragment : Fragment() {
    private lateinit var productDetailsViewModel: ProductDetailsViewModel
    private var productId: String? = null

    companion object {
        fun instance(): ProductDetailsFragment {
            return ProductDetailsFragment()
        }

        fun instance(productId: String): ProductDetailsFragment {
            val fragment = ProductDetailsFragment()
            val bundle = Bundle()

            bundle.putString("PRODUCT_ID", productId)
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
        productDetailsViewModel = ViewModelProviders.of(this).get(ProductDetailsViewModel::class.java)

        if (arguments != null) {
            productId = arguments?.getString("PRODUCT_ID")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (productId == null) {
            return
        }

        productDetailsViewModel.getProduct(productId!!).observe(this, Observer {
            setupView(view, it)
        })
    }

    private fun setupView(view: View, product: Product) {

        Glide.with(this)
            .load(product.imageFrontUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(productDetailsImage)

        Glide.with(this)
            .load(product.imageNutritionUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(productDetailsNutritionImage)

        productNameDetailsTextView.text = product.productName
        productBrandDetailsTextView.text = product.brands
        productQuantityDetailsTextView.text = product.quantity
    }
}