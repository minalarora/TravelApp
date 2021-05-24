package com.srijan.travelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivityAddProfileBinding
import com.srijan.travelapp.viewmodels.AddProfileViewModel

class AddProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityAddProfileBinding>(this,R.layout.activity_add_profile)
            .apply {
                viewModel = ViewModelProvider(this@AddProfileActivity).get(AddProfileViewModel::class.java)
                    .apply {

                    }
            }
    }
}