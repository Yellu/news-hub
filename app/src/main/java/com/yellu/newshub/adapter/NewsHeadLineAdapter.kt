package com.yellu.newshub.adapter

import androidx.appcompat.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.yellu.newshub.R
import com.yellu.newshub.database.ArticlesItem
import com.yellu.newshub.database.Response
import kotlinx.android.synthetic.main.news_item.view.*

class NewsHeadLineAdapter: RecyclerView.Adapter<NewsHeadLineAdapter.HeadLineViewHolder>() {

    private var data: Response? = null

    fun updateData(data: Response){
        this.data = data
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HeadLineViewHolder {
        val myView:View =  LayoutInflater.from(p0.context).inflate(R.layout.news_item, p0, false)
        return HeadLineViewHolder(myView)
    }

    override fun getItemCount(): Int {
        if (data != null){
            return data!!.articles.size
        }
        return 0
    }

    override fun onBindViewHolder(p0: HeadLineViewHolder, p1: Int) {

        val item:ArticlesItem = data!!.articles[p1]

        p0.itemView.title.text = item.title

        Glide.with(p0.itemView)
                .asBitmap()
                .load(item.urlToImage)
                .apply(RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.gallery_placeholder)
                        .error(R.drawable.gallery_placeholder))
                .into(p0.itemView.cover_image)
    }

    class HeadLineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}