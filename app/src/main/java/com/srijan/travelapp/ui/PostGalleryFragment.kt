package com.srijan.travelapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.adapters.HomeFragmentPagerAdapter
import com.srijan.travelapp.databinding.FragmentHomeBinding
import com.srijan.travelapp.databinding.FragmentPostGalleryBinding
import com.srijan.travelapp.viewmodels.CreatePostViewModel
import com.srijan.travelapp.viewmodels.HomeViewModel


class PostGalleryFragment : Fragment() {

    private lateinit var binding: FragmentPostGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostGalleryBinding.inflate(inflater, container, false)
            .apply {
                viewModel = ViewModelProvider(requireActivity()).get(CreatePostViewModel::class.java)
                    .apply {

                    }
                lifecycleOwner = this@PostGalleryFragment.viewLifecycleOwner


        }
        return binding.root
    }

}