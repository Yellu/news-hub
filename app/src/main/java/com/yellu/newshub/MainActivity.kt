package com.yellu.newshub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.yellu.newshub.eventbus.CategoryClickEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.main, NewsPagerFragment.newInstance())
                .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) when(item.itemId){
                android.R.id.home -> onBackPressed()
            }
        return super.onOptionsItemSelected(item)
    }

}
