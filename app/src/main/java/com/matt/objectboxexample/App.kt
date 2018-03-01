package com.matt.objectboxexample

import android.app.Application
import io.objectbox.BoxStore

/**
 * Created by matth on 3/1/2018.
 */

class App : Application() {

    //Reference to app database
    lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build()
    }
}

