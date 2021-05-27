package com.srijan.travelapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivityAddProfileBinding
import com.srijan.travelapp.databinding.FragmentHomeBinding
import com.srijan.travelapp.viewmodels.AddProfileViewModel
import com.srijan.travelapp.viewmodels.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HomeFragment.viewLifecycleOwner
            viewModel = ViewModelProvider(this@HomeFragment).get(HomeViewModel::class.java)
                .apply {  }
        }

        return binding.root
    }


}