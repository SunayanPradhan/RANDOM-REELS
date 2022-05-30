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


//        signInBtn=findViewById(R.id.sign_in_btn)
//
//        mAuth= FirebaseAuth.getInstance()
//
//        createRequest()
//
//        signInBtn.setOnClickListener {
//
//            signIn()
//
//        }

        firebaseAuth= FirebaseAuth.getInstance()

        val firebaseUser=firebaseAuth.currentUser

        if(firebaseUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }



    }

//    private fun createRequest(){
//
//        var gso:GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
////            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//
//
//        mGoogleSignInClient=GoogleSignIn.getClient(this,gso)
//
//
//
//    }

//    private fun signIn(){
//
//        var signInIntent=mGoogleSignInClient.signInIntent
//
//        startActivityForResult(signInIntent,RC_SIGN_IN)
//
//
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        when (requestCode) {
//            RC_SIGN_IN -> {
//
//                var task:Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
//
//                try {
//
//                    var account : GoogleSignInAccount =task.getResult(ApiException::class.java)
//
//                    firebaseAuthWithGoogle(account)
//
//                }
//
//                catch (e:ApiException){
//
//
//
//                }
//
//
//            }
//        }
    }

//    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
//
//        var credential=GoogleAuthProvider.getCredential(account.idToken,null)
//
//        mAuth.signInWithCredential(credential)
//            .addOnCompleteListener(this,object : OnCompleteListener<AuthResult>{
//                override fun onComplete(task: Task<AuthResult>) {
//
//                    if (task.isSuccessful){
//
//                        var user: FirebaseUser? =mAuth.currentUser
//
//                        var intent=Intent(this@LogInActivity,MainActivity::class.java)
//
//                        startActivity(intent)
//
//                    }
//                    else{
//
//                        Toast.makeText(this@LogInActivity, "Login failed", Toast.LENGTH_SHORT).show()
//
//                    }
//
//
//                }
//
//
//            })
//
//
//
//    }

    override fun onStart() {
        super.onStart()

//        var user: FirebaseUser? =mAuth.currentUser
//
//        if (user!=null){
//
//            var intent=Intent(this,MainActivity::class.java)
//
//            startActivity(intent)
//
//
//
//        }

    }


}