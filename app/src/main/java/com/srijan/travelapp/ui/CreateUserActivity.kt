package com.srijan.travelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivityCreateUserBinding
import com.srijan.travelapp.viewmodels.CreateUserViewModel

class CreateUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityCreateUserBinding>(this, R.layout.activity_create_user)
            .apply {
                viewModel = ViewModelProvider(this@CreateUserActivity).get(CreateUserViewModel::class.java)
                    .apply {

                    }
            }
    }
}