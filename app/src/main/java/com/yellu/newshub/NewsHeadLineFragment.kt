package com.yellu.newshub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yellu.newshub.adapter.NewsHeadLineAdapter
import com.yellu.newshub.util.NetworkManager
import kotlinx.android.synthetic.main.category_list_fragment.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsHeadLineFragment:Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    companion object {
        fun newInstance(name: String): NewsHeadLineFragment {
            val args = Bundle()
            args.putString("category", name)
            val fragment = NewsHeadLineFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.category_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val actionBar: ActionBar = (activity as AppCompatActivity).supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(true)
        actionBar.title = getString(R.string.app_name)
        toolbar.setTitleTextColor(ContextCompat.getColor(activity as AppCompatActivity, R.color.white))

        news_category.layoutManager = LinearLayoutManager(activity)
        news_category.setHasFixedSize(true)
        news_category.adapter = NewsHeadLineAdapter()

        val category:String = arguments!!.getString("category", null)

        val readWriteMap = hashMapOf("category" to category, "country" to "in",  "page" to 1, "pageSize" to 20)


        val request: Call<ResponseBody> = NetworkManager.getInstance().headLines(readWriteMap as Map<String, Any>?)

        request.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("error", response.message())
            }
        })
    }
}