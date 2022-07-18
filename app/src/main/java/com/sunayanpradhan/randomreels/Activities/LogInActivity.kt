package com.sunayanpradhan.randomreels.Activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.sunayanpradhan.randomreels.R

class LogInActivity : AppCompatActivity() {

//    lateinit var signInBtn:SignInButton
//
//    lateinit var mGoogleSignInClient: GoogleSignInClient
//
//    private val default_web_client_id= "1234"
//
//    lateinit var mAuth:FirebaseAuth
//
//    private val RC_SIGN_IN = 123

    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()

        this.theme?.applyStyle(R.style.FullScreen,false)
        this.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)




        firebaseAuth= FirebaseAuth.getInstance()

        val firebaseUser=firebaseAuth.currentUser

        if(firebaseUser!=null){
            startActivity(Intent(this,SplashScreenActivity::class.java))
            finish()

        }



    }



}