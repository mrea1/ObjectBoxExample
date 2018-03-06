package com.matt.objectboxexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataService = DataService(Person::class.java)

        dataService.deleteAll()

        dataService.add(Person(name="Andrew"), Person(name="Ash"), Person(name="Sam"), Person(name="Scott"), Person(name="Saurav"), Person(name="Joe"), Person(name="Josh"))

        Log.d(TAG,"Full list: " + dataService.getAll())

        Log.d(TAG,"All names starting with with A: " +
                dataService.getFilteredData({
                    it.startsWith(Person_.name, "A")
                })
        )

        Log.d(TAG,"All names starting with with A or S: " +
                dataService.getFilteredData({
                    it.startsWith(Person_.name, "S")
                            .or()
                            .startsWith(Person_.name, "A")
                })
        )

        Log.d(TAG,"Find Andrew: " +
                dataService.getFilteredData({
                    it.equal(Person_.name, "Andrew")
                })
        )
    }
}