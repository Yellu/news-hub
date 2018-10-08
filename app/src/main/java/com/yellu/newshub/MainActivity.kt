package com.yellu.newshub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yellu.newshub.util.NetworkManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.main, NewsCategoryFragment())
                .commit()

        val request:Call<ResponseBody> = NetworkManager.getInstance().headLines()

        request.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("error", response.message())
            }
        })
    }

    override fun onResume() {
        super.onResume()

    }
}
