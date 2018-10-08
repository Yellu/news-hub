package com.yellu.newshub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.category_list_fragment.*

class NewsCategoryFragment:Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.category_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val category: Array<String> = resources.getStringArray(R.array.categories)

        news_category.layoutManager = LinearLayoutManager(activity)
        news_category.setHasFixedSize(true)
        news_category.adapter = CategoryAdapter(category)
    }
}