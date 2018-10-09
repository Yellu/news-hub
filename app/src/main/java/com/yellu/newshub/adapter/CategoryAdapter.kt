package com.yellu.newshub.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yellu.newshub.R
import com.yellu.newshub.eventbus.CategoryClickEvent
import kotlinx.android.synthetic.main.category_item.view.*
import org.greenrobot.eventbus.EventBus

class CategoryAdapter(private val category: Array<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.category_item, p0, false)
        return CategoryHolder(view)
    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(p0: CategoryHolder, p1: Int) {
        p0.itemView.name.text = category[p1]

        p0.itemView.setOnClickListener {
            EventBus.getDefault().post(CategoryClickEvent())
        }
    }

    class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}