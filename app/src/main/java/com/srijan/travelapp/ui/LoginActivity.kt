package com.srijan.travelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivityHomeBinding
import com.srijan.travelapp.databinding.ActivityLoginBinding
import com.srijan.travelapp.databinding.ActivitySplashBinding
import com.srijan.travelapp.viewmodels.LoginViewModel
import com.srijan.travelapp.viewmodels.SplashViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
            .apply {
            viewModel = ViewModelProvider(this@LoginActivity).get(LoginViewModel::class.java).apply {

            }
        }
    }
}