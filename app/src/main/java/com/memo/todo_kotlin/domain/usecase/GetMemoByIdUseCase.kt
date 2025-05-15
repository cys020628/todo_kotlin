package com.memo.todo_kotlin.domain.usecase


import com.memo.todo_kotlin.domain.repository.MemoRepository
import javax.inject.Inject

class GetMemoByIdUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    suspend operator fun invoke(id: Long) = memoRepository.getMemoById(id)
}
