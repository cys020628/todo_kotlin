package com.memo.todo_kotlin.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.memo.todo_kotlin.domain.model.Memo
import com.memo.todo_kotlin.domain.repository.MemoRepository
import javax.inject.Inject

class GetMemosPagingUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    operator fun invoke(): LiveData<PagingData<Memo>> =
        memoRepository.getMemosPaging()
}