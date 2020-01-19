package com.hr.app.productsearch.utils

import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar

class Utils {
    fun showSnackbarLong(layout: View, message: String) {
        var snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    fun showSnackbarError(layout: View, message: String) {
        var snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_LONG)
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }

    fun isTextInputEmpty(text: String): Boolean {
        return text.isNullOrEmpty() || text.equals("")
    }
}