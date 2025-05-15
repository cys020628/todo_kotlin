package com.memo.todo_kotlin.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// 모든 Fragment에서 공통적으로 사용할 추상 클래스
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    // ViewBinding 인스턴스 (onDestroyView 대비 nullable 처리)
    private var _binding: VB? = null
    // 외부에서 접근할 땐 null 아닌 것으로 취급
    val binding get() = _binding!!

    // 자식 Fragment에서 구현해야 할 ViewBinding inflate 메서드
    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = inflateBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        // 메모리 누수 방지 위해 binding 제거
        _binding = null
        super.onDestroyView()
    }
}