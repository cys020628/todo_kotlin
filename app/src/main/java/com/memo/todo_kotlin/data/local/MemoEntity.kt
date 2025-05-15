package com.memo.todo_kotlin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MemoTable")
data class MemoEntity (
    @PrimaryKey(autoGenerate = true) val memoId:Long = 0,
    val memoTitle:String,
    val memoContent:String,
    val memoDate:Long = System.currentTimeMillis()
)