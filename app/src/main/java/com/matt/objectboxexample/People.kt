package com.matt.objectboxexample

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany


/**
 * Created by Josh Mieczkowski on 3/14/2018.
 */
@Entity
class People {

    @Id
    var id: Long = 0

    @Backlink
    lateinit var people: ToMany<Person>
}