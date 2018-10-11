package com.yellu.newshub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yellu.newshub.adapter.NewsPagerAdapter
import kotlinx.android.synthetic.main.news_pager_fragment.*

class NewsPagerFragment:Fragment() {

    companion object {
        fun newInstance(): NewsPagerFragment{
            return NewsPagerFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_pager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val actionBar: ActionBar = (activity as AppCompatActivity).supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowTitleEnabled(true)
        actionBar.title = getString(R.string.app_name)

        toolbar.setTitleTextColor(ContextCompat.getColor(activity as AppCompatActivity, R.color.white))

        val category: Array<String> = resources.getStringArray(R.array.categories)

        news_pager.adapter = NewsPagerAdapter(childFragmentManager, category)
        tabs.setupWithViewPager(news_pager, false)
    }
}