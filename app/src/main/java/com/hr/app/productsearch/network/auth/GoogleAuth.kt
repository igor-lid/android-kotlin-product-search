package com.hr.app.productsearch.network.auth

import android.content.Context
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient

object GoogleAuth {
    private var googleSignInOptions: GoogleSignInOptions = GoogleSignInOptions
        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()

    private var RC_SIGN_IN: Int = 1

    public fun getGoogleSignInClient(ctx: Context): GoogleSignInClient {
        return GoogleSignIn.getClient(ctx, googleSignInOptions)
    }

    public fun getRcSignIn(): Int {
        return RC_SIGN_IN
    }

}