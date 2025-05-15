package com.memo.todo_kotlin.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.memo.todo_kotlin.domain.model.Memo

interface MemoRepository {
    fun getAllMemos():LiveData<List<Memo>>

    fun getMemosPaging(): LiveData<PagingData<Memo>>

    suspend fun insertMemo(memo: Memo)

    suspend fun deleteMemo(memo:Memo)

    suspend fun getMemoById(id:Long): Memo?
}