package org.superbiz.moviefun

import com.fasterxml.jackson.databind.ObjectReader
import java.io.IOException
import java.io.InputStream

@Throws(IOException::class)
fun <T> readFromCsv(objectReader: ObjectReader, inputStream: InputStream): List<T> =
    objectReader
            .readValues<T>(inputStream)
            .asSequence()
            .toList()