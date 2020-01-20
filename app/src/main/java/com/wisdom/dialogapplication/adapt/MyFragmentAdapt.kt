package com.wisdom.dialogapplication.adapt

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @description: MyFragmentAdapt
 * @author: Felix J
 * @time: 2020/1/19 9:28
 */
class MyFragmentAdapt(
    fm: FragmentManager,
    fragments: List<Fragment>
) : FragmentPagerAdapter(fm) {

    private val fragmentList = fragments

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}