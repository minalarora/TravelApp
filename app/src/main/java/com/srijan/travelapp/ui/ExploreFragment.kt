package com.srijan.travelapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.srijan.travelapp.R
import com.srijan.travelapp.adapters.ExploreFragmentPagerAdapter
import com.srijan.travelapp.adapters.HomeFragmentPagerAdapter
import com.srijan.travelapp.databinding.FragmentExploreBinding
import com.srijan.travelapp.databinding.FragmentHomeBinding
import com.srijan.travelapp.viewmodels.ExploreViewModel
import com.srijan.travelapp.viewmodels.HomeViewModel

class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentExploreBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@ExploreFragment.viewLifecycleOwner
            viewModel = ViewModelProvider(this@ExploreFragment).get(ExploreViewModel::class.java)
                .apply {  }
        }
        binding.include.findViewById<TextView>(R.id.title).apply { text = "EXPLORE" }
        binding.viewpager.adapter = ExploreFragmentPagerAdapter(childFragmentManager)
        binding.slidingTabs.setupWithViewPager(binding.viewpager)
        return binding.root
    }

}