package com.hr.app.productsearch.screen.Login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hr.app.productsearch.R

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Hide action bar
        if (supportActionBar != null) supportActionBar?.hide()
    }
}