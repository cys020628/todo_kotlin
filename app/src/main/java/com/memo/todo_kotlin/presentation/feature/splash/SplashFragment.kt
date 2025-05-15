package com.memo.todo_kotlin.presentation.feature.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.memo.todo_kotlin.R
import com.memo.todo_kotlin.databinding.FragmentSplashBinding
import com.memo.todo_kotlin.presentation.base.BaseFragment
import com.memo.todo_kotlin.presentation.util.navigateTo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(2000)
            // 2초 후 화면 이동
            navigateTo(R.id.action_splashFragment_to_homeFragment)
        }
    }
}