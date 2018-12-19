package com.yellu.newshub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.yellu.newshub.util.NewsViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        if (model.isFirstLaunch){
            model.isFirstLaunch = false
            supportFragmentManager.beginTransaction()
                    .add(R.id.main, NewsPagerFragment.newInstance())
                    .commit()
        }
    }

    override fun onStart() {
        super.onStart()
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

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
