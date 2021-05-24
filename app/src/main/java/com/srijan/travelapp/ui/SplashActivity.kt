package com.srijan.travelapp.ui

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivitySplashBinding
import com.srijan.travelapp.viewmodels.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivitySplashBinding>(this@SplashActivity,R.layout.activity_splash)
            .apply {

            viewModel = ViewModelProvider(this@SplashActivity).get(SplashViewModel::class.java).apply {

                checkCurrentUser(this@SplashActivity){
                    if (it)
                    {
                        Intent(this@SplashActivity,HomeActivity::class.java).
                        also {
                            startActivity(it)
                            this@SplashActivity.finish()
                        }
                    }
                    else
                    {
                        Intent(this@SplashActivity,LoginActivity::class.java).
                        also {
                            startActivity(it)
                            this@SplashActivity.finish()
                        }
                    }
                }
            }
        }

    }
}

