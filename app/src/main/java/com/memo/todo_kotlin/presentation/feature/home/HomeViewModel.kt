package com.memo.todo_kotlin.presentation.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memo.todo_kotlin.domain.model.Memo
import com.memo.todo_kotlin.domain.usecase.MemoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val memoUseCases: MemoUseCases
) : ViewModel() {

    // 메모 리스트
    val memoData = memoUseCases.getMemosPaging()

    // 메모 삭제
    fun deleteMemo(memo: Memo) {
        viewModelScope.launch {
            memoUseCases.deleteMemo(memo)
        }
    }

    fun insertMemo(
        title: String,
        content: String
    ) {
        val memo = Memo(
            id = 0L,
            title = title,
            content = content,
            date = System.currentTimeMillis()
        )
        viewModelScope.launch {
            memoUseCases.insertMemo(memo)
        }
    }
}