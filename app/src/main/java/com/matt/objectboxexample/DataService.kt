package com.matt.objectboxexample

import io.objectbox.Box
import io.objectbox.kotlin.boxFor
import io.objectbox.query.QueryBuilder

/**
 * Created by matt on 3/1/2018.
 */

open class DataService<T : Any>(app: App) {

    val boxStore = app.boxStore
    var box: Box<T>? = null

    private fun <V> checkStarted(func: (box: Box<T>) -> V) : V {
        if (box == null) {
            throw IllegalStateException("You must call start() before using the service")
        } else {
           return func(box!!)
        }
    }

    fun getAll(): List<T> = checkStarted { it.all as List<T> }

    fun add(vararg data: T) = checkStarted { it.put(data.asList()) }

    fun delete(vararg data: T) = checkStarted { it.remove(data.toList()) }

    fun queryBuilder() = checkStarted { it.query() }

    fun executeQuery(builder: QueryBuilder<T>) = checkStarted { builder.build().find() }

    fun deleteAll() = checkStarted { it.removeAll() }

}

inline fun <reified T : Any> DataService<T>.start() : DataService<T> {
    box = boxStore.boxFor()
    return this
}
