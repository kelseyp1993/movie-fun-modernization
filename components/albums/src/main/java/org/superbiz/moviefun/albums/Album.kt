package org.superbiz.moviefun.albums

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Album : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var artist: String? = null
    var title: String? = null
    var year: Int = 0
    var rating: Int = 0

    constructor() {}

    constructor(artist: String, title: String, year: Int, rating: Int) {
        this.artist = artist
        this.title = title
        this.year = year
        this.rating = rating
    }

    fun hasId(): Boolean {
        return id != null
    }

    fun isEquivalent(other: Album): Boolean {
        if (year != other.year) return false
        if (!isEqual(title, other.title)) return false
        return isEqual(artist, other.artist)

    }

    companion object {

        const val serialVersionUID = 1L

        private fun <T> isEqual(one: T?, other: T?): Boolean =
                !if (one != null) one != other else other != null
    }
}
