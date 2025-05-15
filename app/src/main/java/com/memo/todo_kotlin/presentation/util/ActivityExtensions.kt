package com.memo.todo_kotlin.presentation.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

// 지정한 ID의 FragmentContainerView에서 NavController를 꺼내는 확장 함수
fun AppCompatActivity.setupNavController(@IdRes containerId: Int): NavController {
    // 해당 ID의 Fragment를 NavHostFragment로 캐스팅
    val navHostFragment = supportFragmentManager
        .findFragmentById(containerId) as NavHostFragment
    // 내부 NavController 반환
    return navHostFragment.navController
}
