package com.matt.objectboxexample

import android.app.Application
import io.objectbox.BoxStore

/**
 * Created by matth on 3/1/2018.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DataService.init(this)
    }
}

