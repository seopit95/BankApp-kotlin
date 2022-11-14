package com.example.chap11drawerlayout2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
    val fragmentList = ArrayList<Fragment>()
    val titleList = ArrayList<String>()

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String){
        this.fragmentList.add(fragment)
        this.titleList.add(title)
    }
}