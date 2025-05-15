package com.memo.todo_kotlin.domain.usecase



data class MemoUseCases(
    val getAllMemos: GetAllMemoUseCase,
    val getMemosPaging: GetMemosPagingUseCase,
    val insertMemo: InsertMemoUseCase,
    val deleteMemo: DeleteMemoUseCase,
    val getMemoById: GetMemoByIdUseCase
)
