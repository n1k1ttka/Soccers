package com.example.soccers.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.format.DateTimeFormatter
import kotlin.math.abs


@RequiresApi(Build.VERSION_CODES.O)
fun datefromUnix(unix: Long?): String{

    if (unix != null) {
        val dateString = DateTimeFormatter.ISO_INSTANT.format(java.time.Instant.ofEpochSecond(unix))
        return dateString.drop(11).dropLast(4) + " UTC"
    } else {
        return "Date = NULL"
    }
}

fun gameScore(unix1: Long, unix2: Long, time: String): String {

    val dif = abs(unix1 - unix2)/60

    if (dif < 45) {
        return "$dif мин. $time тайм"
    } else if (dif in 45..59) {
        return "break"
    } else {
        return "finished"
    }
}