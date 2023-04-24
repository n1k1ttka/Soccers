package com.example.soccers.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

const val DATE_PATTERN = "yyyy-MM-dd"

/**
 * Функция получения даты
 *
 * @return строка в формате "HH:mm"
 */
@SuppressLint("SimpleDateFormat")
fun getDate(): String {
    val time = Calendar.getInstance().time
    val formatter = SimpleDateFormat(DATE_PATTERN)
    return formatter.format(time)
}