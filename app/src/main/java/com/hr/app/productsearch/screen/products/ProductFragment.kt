package com.hr.app.productsearch.screen.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hr.app.productsearch.R

class ProductFragment : Fragment() {
    private lateinit var productsViewModel: ProductsViewModel
    private lateinit var productsRecyclerViewAdapter: ProductsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productsViewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productsRecyclerView: RecyclerView = view.findViewById(R.id.productsRecyclerView)
        productsRecyclerView.layoutManager = LinearLayoutManager(context)

        productsRecyclerViewAdapter = ProductsRecyclerViewAdapter()

        productsRecyclerView.adapter = productsRecyclerViewAdapter
    }

    override fun onStart() {
        super.onStart()

        println("[PRODUCT FRAGMENT] ")
        productsViewModel.getProducts().observe(this, Observer {
            productsRecyclerViewAdapter.products = it
        })
    }

}