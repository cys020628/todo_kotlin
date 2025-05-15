package com.memo.todo_kotlin.di

import com.memo.todo_kotlin.domain.repository.MemoRepository
import com.memo.todo_kotlin.domain.usecase.DeleteMemoUseCase
import com.memo.todo_kotlin.domain.usecase.GetAllMemoUseCase
import com.memo.todo_kotlin.domain.usecase.GetMemoByIdUseCase
import com.memo.todo_kotlin.domain.usecase.GetMemosPagingUseCase
import com.memo.todo_kotlin.domain.usecase.InsertMemoUseCase
import com.memo.todo_kotlin.domain.usecase.MemoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideMemoUseCases(memoRepository: MemoRepository) =
        MemoUseCases(
            getAllMemos = GetAllMemoUseCase(memoRepository),
            getMemosPaging = GetMemosPagingUseCase(memoRepository),
            insertMemo = InsertMemoUseCase(memoRepository),
            deleteMemo = DeleteMemoUseCase(memoRepository),
            getMemoById = GetMemoByIdUseCase(memoRepository)
        )
}