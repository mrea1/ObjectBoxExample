package com.matt.objectboxexample

import android.content.Context
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import io.objectbox.query.QueryBuilder

/**
 * Created by matt on 3/1/2018.
 */

open class DataService<T>(clazz: Class<T>) {

    companion object {
        private lateinit var boxStore: BoxStore

        fun init(context: Context) {
            boxStore = MyObjectBox.builder().androidContext(context).build()
        }
    }

    private val box: Box<T> = boxStore.boxFor(clazz)

    fun getAll(): List<T> = box.all

    fun add(vararg data: T) = box.put(data.asList())

    fun delete(vararg data: T) = box.remove(data.toList())

    fun queryBuilder(): QueryBuilder<T> = box.query()

    inline fun executeQuery(config: (QueryBuilder<T>) -> QueryBuilder<T>){
        val builder = queryBuilder()
        config(builder).build().find()
    }

    fun deleteAll() = box.removeAll()
}

