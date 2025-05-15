package com.memo.todo_kotlin.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import com.memo.todo_kotlin.R
import com.memo.todo_kotlin.presentation.util.setupNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 상태바, 내비게이션바와 콘텐츠가 겹칠 수 있도록 설정
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 시스템 바(상단, 하단) 여백만큼 패딩을 넣어주는 리스너 설정
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // NavController 초기화 (확장 함수 활용)
        navController = setupNavController(R.id.nav_host_fragment_container)
    }
}