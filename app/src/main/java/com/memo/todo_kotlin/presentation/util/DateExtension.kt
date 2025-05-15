package com.memo.todo_kotlin.presentation.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toFormattedDateString(pattern: String = "yyyy.MM.dd a hh시 mm분"): String {
    return SimpleDateFormat(pattern, Locale.getDefault())
        .format(Date(this))
}