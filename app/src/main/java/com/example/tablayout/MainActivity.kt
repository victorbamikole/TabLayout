package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val tabTitle = mutableListOf<String>()
    val items = mutableListOf<ViewData>()
    val imageId: Array<Int> = arrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = ArrayList<ViewData>()

        initData()
        initView()

    }

    private fun initData(){
        tabTitle.add("Day").toString()
        tabTitle.add("Week").toString()
        tabTitle.add("Month").toString()

        items.add(ViewData("Day", imageId[0]))
        items.add(ViewData("Day", imageId[1]))
        items.add(ViewData("Day", imageId[2]))
    }

    private fun initView(){

        val adapter = ViewPagerAdapter(items)
        binding.viewPager2.adapter = adapter

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager2



        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}