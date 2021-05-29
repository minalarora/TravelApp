package com.srijan.travelapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.FragmentCreatePostBinding
import com.srijan.travelapp.viewmodels.CreatePostViewModel


class CreatePostFragment : Fragment() {

    private lateinit var binding: FragmentCreatePostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreatePostBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = this@CreatePostFragment.viewLifecycleOwner
                viewModel = ViewModelProvider(requireActivity()).get(CreatePostViewModel::class.java)
                    .apply {
                        Log.d("minal",imageList.value.toString())
                    }
            }
        return binding.root
    }
}
