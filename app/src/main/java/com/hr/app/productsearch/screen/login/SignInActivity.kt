package com.hr.app.productsearch.screen.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.hr.app.productsearch.MainActivity
import com.hr.app.productsearch.R
import com.hr.app.productsearch.network.auth.GoogleAuth
import com.hr.app.productsearch.repository.ProductRepository
import com.hr.app.productsearch.screen.products.ProductsActivity
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity : AppCompatActivity() {
    //private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Hide action bar
        if (supportActionBar != null) supportActionBar?.hide()

        login_button.setOnClickListener {
            val signInIntent: Intent = GoogleAuth.getGoogleSignInClient(this).signInIntent
            startActivityForResult(signInIntent, GoogleAuth.getRcSignIn())
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is already signed in
        val googleSignInAccount: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(this)
        println(googleSignInAccount)
        if (googleSignInAccount != null) {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GoogleAuth.getRcSignIn()) {
            // start new activity
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}