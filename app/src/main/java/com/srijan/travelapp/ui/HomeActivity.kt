package com.srijan.travelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

        setCurrentFragment(HomeFragment(),"home")

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home -> setCurrentFragment(HomeFragment(),"home")
                R.id.explore -> setCurrentFragment(ExploreFragment(),"explore")
                R.id.chat -> setCurrentFragment(ChatFragment(),"chat")
                R.id.profile -> setCurrentFragment(ProfileFragment(),"profile")
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment,tag: String)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id,fragment,tag)
            commit()
        }
    }
}