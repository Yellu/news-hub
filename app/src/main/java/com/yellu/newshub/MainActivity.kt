package com.yellu.newshub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.yellu.newshub.eventbus.CategoryClickEvent
import com.yellu.newshub.util.NetworkManager
import okhttp3.ResponseBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
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
    }

    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this)
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) when(item.itemId){
                android.R.id.home -> onBackPressed()
            }
        return super.onOptionsItemSelected(item)
    }

    @Subscribe
    fun onEvent(event: CategoryClickEvent) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.main, NewsHeadLineFragment.newInstance(event.name))
                .addToBackStack(null)
                .commit()
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }
}
