package com.memo.todo_kotlin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.memo.todo_kotlin.data.local.MemoDao
import com.memo.todo_kotlin.data.mapper.toDomain
import com.memo.todo_kotlin.data.mapper.toEntity
import com.memo.todo_kotlin.domain.model.Memo
import com.memo.todo_kotlin.domain.repository.MemoRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(
    private val memoDao: MemoDao
) : MemoRepository {

    override fun getAllMemos(): LiveData<List<Memo>> {
        return memoDao.getAllMemos().map { list ->
            list.map { it.toDomain() }
        }
    }

    override fun getMemosPaging(): LiveData<PagingData<Memo>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { memoDao.getAllMemosPaging() }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
            .asLiveData()
    }

    override suspend fun insertMemo(memo: Memo) =
        memoDao.upsertMemo(memo.toEntity())


    override suspend fun deleteMemo(memo: Memo) =
        memoDao.deleteMemo(memo.toEntity())


    override suspend fun getMemoById(id: Long): Memo? =
        memoDao.getMemoById(id)?.toDomain()
}