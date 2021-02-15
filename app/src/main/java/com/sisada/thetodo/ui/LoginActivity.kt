package com.sisada.thetodo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sisada.thetodo.R
import com.sisada.thetodo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private var mAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            var intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {
            //validate first

            binding.layoutContent.visibility = View.INVISIBLE
            binding.layoutLoading.visibility = View.VISIBLE

            val email = binding.textinputEmail.editText?.text.toString()
            val password = binding.textinputEmail.editText?.text.toString()
            Firebase.auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                    } else{

                    }
                }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser

    }
}