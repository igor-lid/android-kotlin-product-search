package com.hr.app.productsearch.screen.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hr.app.productsearch.R
import com.hr.app.productsearch.model.Product
import kotlinx.android.synthetic.main.rv_item_product.view.*

class ProductsRecyclerViewAdapter : RecyclerView.Adapter<ProductsRecyclerViewAdapter.ProductsViewHolder>() {
    var onItemClick: ((Product) -> Unit)? = null
    var products: List<Product> = ArrayList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ProductsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val productImageView: ImageView = view.findViewById(R.id.productImage)
        init {
            view.setOnClickListener {
                onItemClick?.invoke(products[adapterPosition])
            }
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rv_item_product, parent, false)

        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product: Product = products[position]

        Glide.with(holder.itemView.context)
            .load(product.imageFrontUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.productImageView)

//        holder.itemView.productNameTextView.text = if (product.productName.equals("")) product.productName else "unknown"
//        holder.itemView.productBrandTextView.text = if (product.brands.equals("")) product.brands else "unknown"
//        holder.itemView.productQuantityTextView.text = if (product.quantity.equals("")) product.quantity else "unknown"

        holder.itemView.productNameTextView.text = product.productName
        holder.itemView.productBrandTextView.text = product.brands
        holder.itemView.productQuantityTextView.text = product.quantity

    }
}