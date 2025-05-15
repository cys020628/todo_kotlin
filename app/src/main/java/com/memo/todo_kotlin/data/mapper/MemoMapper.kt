package com.memo.todo_kotlin.data.mapper

import com.memo.todo_kotlin.data.local.MemoEntity
import com.memo.todo_kotlin.domain.model.Memo


fun MemoEntity.toDomain() = Memo(
    id = memoId,
    title = memoTitle,
    content = memoContent,
    date = memoDate
)

fun Memo.toEntity() = MemoEntity(
    memoId = id,
    memoTitle = title,
    memoContent = content,
    memoDate = date
)