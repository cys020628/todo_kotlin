package com.memo.todo_kotlin.domain.usecase


import com.memo.todo_kotlin.domain.model.Memo
import com.memo.todo_kotlin.domain.repository.MemoRepository
import javax.inject.Inject

class DeleteMemoUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    suspend operator fun invoke(memo: Memo) = memoRepository.deleteMemo(memo)
}