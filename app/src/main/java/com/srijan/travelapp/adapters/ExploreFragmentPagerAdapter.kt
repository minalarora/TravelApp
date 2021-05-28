package com.srijan.travelapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.srijan.travelapp.ui.FollowingFragment
import com.srijan.travelapp.ui.NearyouFragment
import com.srijan.travelapp.ui.TrendingFragment
import com.srijan.travelapp.ui.YouFragment

class ExploreFragmentPagerAdapter(fm: FragmentManager)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            TrendingFragment()
        } else {
            NearyouFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (position == 0) {
            "TRENDING"
        } else {
            "NEAR YOU"
        }
    }
}