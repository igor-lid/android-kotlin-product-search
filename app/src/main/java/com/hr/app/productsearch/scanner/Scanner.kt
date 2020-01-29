package com.hr.app.productsearch.scanner

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.hr.app.productsearch.model.Product
import com.hr.app.productsearch.repository.ProductRepository
import com.hr.app.productsearch.screen.productdetails.ProductDetailsActivity
import com.hr.app.productsearch.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class Scanner {
    companion object {
        fun startScanner(requestCode: Int, resultCode: Int, data: Intent?, view: View) {
            val result: IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

            if (result.contents != null) {
                ProductRepository.scannedValue = result.contents.toString()
                ProductDetailsActivity.start(view.context)
            } else {
                Utils.showSnackbarError(view, "Scan failed!")
            }
        }
    }
}