package com.hr.app.productsearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hr.app.productsearch.repository.ProductRepository
import com.hr.app.productsearch.screen.products.ProductsActivity
import com.hr.app.productsearch.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide action bar
        if (supportActionBar != null) supportActionBar?.hide()

        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        search_button.setOnClickListener {
            val searchValue: String = search_textInput.text.toString()

            // Check if input is empty
            if (Utils.isTextInputEmpty(searchValue)) {
                Utils.showSnackbarError(mainLayout, "Please enter text!")
                return@setOnClickListener
            }
            // Set search value in repository
            ProductRepository.searchValue = searchValue

            // start new activity
            val intent = Intent(it.context, ProductsActivity::class.java)
            it.context.startActivity(intent)

            clearInputs()
        }
    }
    private fun clearInputs() {
        search_textInput.text?.clear()
    }

}
