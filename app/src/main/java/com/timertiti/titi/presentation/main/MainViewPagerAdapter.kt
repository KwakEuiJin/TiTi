package com.timertiti.titi.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.timertiti.titi.presentation.*
import com.timertiti.titi.presentation.todo.TodoFragment

class MainViewPagerAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment = when(position) {
        0 -> TimerFragment()
        1 -> StopWatchFragment()
        2 -> TodoFragment()
        3 -> LogFragment()
        else -> SettingFragment()
    }

}