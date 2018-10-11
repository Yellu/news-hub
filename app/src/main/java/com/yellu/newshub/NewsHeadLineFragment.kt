package com.yellu.newshub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
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
import com.google.gson.Gson

class NewsHeadLineFragment:Fragment() {

    private var adapter:NewsHeadLineAdapter? = null

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

        news_category.layoutManager = LinearLayoutManager(activity)
        news_category.setHasFixedSize(true)
        adapter = NewsHeadLineAdapter()
        news_category.adapter = adapter

        val category:String = arguments!!.getString("category", null)

        loader.show()

        getHeadLines(category)
    }

    private fun getHeadLines(category: String) {

        val readWriteMap = hashMapOf("category" to category, "country" to "in",  "page" to 1, "pageSize" to 20)

        val request: Call<ResponseBody> = NetworkManager.getInstance().headLines(readWriteMap as Map<String, Any>?)

        request.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loader.hide()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                loader.hide()
                if (response.isSuccessful){
                    saveData(response.body())
                }
            }
        })
    }

    private fun saveData(body: ResponseBody?) {
        val str:String = body!!.string()
        val gson = Gson()

        val news:com.yellu.newshub.database.Response = gson.fromJson(str, com.yellu.newshub.database.Response::class.java)
        adapter!!.updateData(news)
        adapter!!.notifyDataSetChanged()
    }
}