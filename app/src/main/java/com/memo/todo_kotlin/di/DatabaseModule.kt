package com.memo.todo_kotlin.di

import android.content.Context
import androidx.room.Room
import com.memo.todo_kotlin.data.local.MemoDao
import com.memo.todo_kotlin.data.local.MemoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMemoDatabase(
        @ApplicationContext context: Context
    ): MemoDatabase {
        return Room.databaseBuilder(
            context,
            MemoDatabase::class.java,
            "memoTable"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMemoDao(memoDatabase: MemoDatabase): MemoDao {
        return memoDatabase.memoDao()
    }
}