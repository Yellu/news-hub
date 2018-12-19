package com.yellu.newshub.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.yellu.newshub.NewsHeadLineFragment

class NewsPagerAdapter(fm: FragmentManager?, val category: Array<String>) : FragmentStatePagerAdapter(fm!!) {

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