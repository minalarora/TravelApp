package com.srijan.travelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivityHomeBinding
import com.srijan.travelapp.databinding.ActivitySplashBinding
import com.srijan.travelapp.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
            .apply {
            viewModel = ViewModelProvider(this@HomeActivity).get(HomeViewModel::class.java).apply {

            }
        }
    }
}