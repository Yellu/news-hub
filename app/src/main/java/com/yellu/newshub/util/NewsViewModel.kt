package com.yellu.newshub.util

import androidx.lifecycle.ViewModel

class NewsViewModel:ViewModel() {
    var category:String? = null
    var isFirstLaunch:Boolean = true
}