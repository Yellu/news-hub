package com.yellu.newshub.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yellu.newshub.R
import kotlinx.android.synthetic.main.category_item.view.*

class NewsHeadLineAdapter: RecyclerView.Adapter<NewsHeadLineAdapter.HeadLineViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HeadLineViewHolder {
        val view:View =  LayoutInflater.from(p0.context).inflate(R.layout.category_item, p0, false)
        return HeadLineViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: HeadLineViewHolder, p1: Int) {
        p0.itemView.name.text = "myBataz"
    }

    class HeadLineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}