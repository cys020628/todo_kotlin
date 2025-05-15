package com.memo.todo_kotlin.domain.model

data class Memo(
    val id:Long,
    val title: String,
    val content: String,
    val date: Long
)