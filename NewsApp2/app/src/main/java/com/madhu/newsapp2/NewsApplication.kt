package com.madhu.newsapp2

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"Inside on create function ")
    }

    companion object{
     const val   TAG = "NewsApplication"
    }
}