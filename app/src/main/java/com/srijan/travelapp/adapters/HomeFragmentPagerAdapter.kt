package com.srijan.travelapp.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.srijan.travelapp.ui.FollowingFragment
import com.srijan.travelapp.ui.YouFragment

class HomeFragmentPagerAdapter(fm: FragmentManager)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            FollowingFragment()
        } else {
            YouFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (position == 0) {
            "FOLLOWING"
        } else {
            "YOU"
        }
    }
}