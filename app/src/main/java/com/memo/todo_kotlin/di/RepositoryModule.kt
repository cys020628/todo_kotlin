package com.memo.todo_kotlin.di

import com.memo.todo_kotlin.data.local.MemoDao
import com.memo.todo_kotlin.data.repository.MemoRepositoryImpl
import com.memo.todo_kotlin.domain.repository.MemoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMemoRepository(memoDao: MemoDao): MemoRepository {
        return MemoRepositoryImpl(memoDao)
    }
}