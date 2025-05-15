package com.memo.todo_kotlin.presentation.util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// 목적지 ID와 번들을 받아 안전하게 화면 이동
fun Fragment.navigateTo(@IdRes actionId: Int, args: Bundle? = null) {
    findNavController().navigate(actionId, args)
}

// 현재 스택에서 뒤로가기 수행
fun Fragment.popBackStack() {
    findNavController().popBackStack()
}