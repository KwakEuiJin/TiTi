package com.timertiti.titi.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.timertiti.titi.R
import com.timertiti.titi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter = MainViewPagerAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        initViewPager()
        initBottomNavigationView()
    }

    private fun initViewPager() {
        binding.viewPager2.run {
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationView.menu.getItem(position).isChecked = true
                }
            })
        }
    }

    private fun initBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_one -> {
                    binding.viewPager2.currentItem = 0
                    return@setOnItemSelectedListener true
                }
                R.id.item_two -> {
                    binding.viewPager2.currentItem = 1
                    return@setOnItemSelectedListener true
                }
                R.id.item_three -> {
                    binding.viewPager2.currentItem = 2
                    return@setOnItemSelectedListener true
                }
                R.id.item_four -> {
                    binding.viewPager2.currentItem = 3
                    return@setOnItemSelectedListener true
                }
                R.id.item_five -> {
                    binding.viewPager2.currentItem = 4
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }
}