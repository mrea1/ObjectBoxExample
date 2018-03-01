package com.matt.objectboxexample

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by matt on 3/1/2018.
 */

@Entity
data class Person(@Id var id: Long = 0, var name: String = "")