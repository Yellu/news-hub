package com.yellu.newshub.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.yellu.newshub.NewsHeadLineFragment

class NewsPagerAdapter(fm: FragmentManager?, val category: Array<String>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        return NewsHeadLineFragment.newInstance(category[p0])
    }

    override fun getCount(): Int {
        return category.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return category[position]
    }
}