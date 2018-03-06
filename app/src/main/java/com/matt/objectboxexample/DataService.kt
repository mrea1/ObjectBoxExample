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

    val box: Box<T> = boxStore.boxFor(clazz)

    fun getAll(): List<T> = box.all

    fun add(vararg data: T) = box.put(data.asList())

    fun delete(vararg data: T) = box.remove(data.toList())

    fun queryBuilder() = box.query()

    fun executeQuery(builder: QueryBuilder<T>) = builder.build().find()

    fun deleteAll() = box.removeAll()
}
