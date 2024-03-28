package com.example.commonlisttask

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val viewModel:MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) {
                tab, position -> tab.text = getTextTab(position); tab.icon = ContextCompat.getDrawable(this,R.drawable.baseline_view_list_24)
        }.attach()
    }

    private fun getTextTab(position:Int): String{
        return when(position){
            0 -> resources.getString(R.string.first)
            1 -> resources.getString(R.string.second)
            2 -> resources.getString(R.string.third)
            3 -> resources.getString(R.string.fourth)
            4 -> resources.getString(R.string.fifth)
            else -> resources.getString(R.string.other)
        }
    }
}