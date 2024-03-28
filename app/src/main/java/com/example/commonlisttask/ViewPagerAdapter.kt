package com.example.commonlisttask

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: MainActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return createFragmentByPosition(position)
    }

    private fun createFragmentByPosition(position: Int): Fragment{
        return when(position){
            0 -> PageFragment.newInstance(position)
            else -> PageFragment.newInstance(position)
        }
    }
}