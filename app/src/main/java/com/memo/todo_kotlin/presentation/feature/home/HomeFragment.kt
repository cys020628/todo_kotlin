package com.memo.todo_kotlin.presentation.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.observe
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.memo.todo_kotlin.R
import com.memo.todo_kotlin.databinding.FragmentHomeBinding
import com.memo.todo_kotlin.presentation.adapter.MemoAdapter
import com.memo.todo_kotlin.presentation.base.BaseFragment
import com.memo.todo_kotlin.presentation.util.navigateTo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    // HomeViewModel을 Fragment 생명주기에 맞춰 주입
    private val homeViewModel: HomeViewModel by viewModels()

    // 메모 리스트를 출력할 PagingAdapter
    private lateinit var memoAdapter: MemoAdapter

    /**
     * BaseFragment에서 구현이 요구되는 ViewBinding 인플레이터
     */
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    /**
     * 프래그먼트 View 초기화 이후 호출되는 함수
     * - RecyclerView 설정
     * - ViewModel LiveData 관찰
     * - FAB 클릭 리스너 설정
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeMemoList()
        setupListeners()
    }

    /**
     * 메모 RecyclerView 구성 함수
     * - 어댑터 초기화
     * - 삭제 버튼 클릭 시 ViewModel에 전달
     */
    private fun setupRecyclerView() {
        memoAdapter = MemoAdapter(
            onDeleteClicked = { memo ->
                homeViewModel.deleteMemo(memo)
            }
        )

        binding.memoRv.apply {x
            adapter = memoAdapter
            // 성능 최적화를 위한 고정 크기 설정
            setHasFixedSize(true)
            // 아이템들의 크기가 고정일때 리싸이클러뷰에 고정이라고 알려주며 성능 최적화 효과 기대
        }
    }

    /**
     * 메모 목록 LiveData 관찰 함수
     * - ViewModel로부터 PagingData<Memo>를 받아 어댑터에 submit
     */
    private fun observeMemoList() {
        homeViewModel.memoData.observe(viewLifecycleOwner) { pagingData ->
            memoAdapter.submitData(lifecycle, pagingData)
        }
    }

    /**
    * 사용자 클릭 이벤트 설정 함수
    * - 현재는 테스트용으로 insertMemo 직접 호출
    * - 원래는 addMemo 화면으로 이동해야 함
    */
    private fun setupListeners() {
        binding.addMemoFab.setOnClickListener {
            // navigateTo(R.id.action_homeFragment_to_addMemoFragment)
            homeViewModel.insertMemo("ad","asd",)
        }
    }
}