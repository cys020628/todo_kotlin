package com.memo.todo_kotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.memo.todo_kotlin.databinding.ItemMemoBinding
import com.memo.todo_kotlin.domain.model.Memo
import com.memo.todo_kotlin.presentation.util.toFormattedDateString

/**
 * Paging3 기반의 메모 리스트 어댑터
 * - Memo 객체를 리스트로 출력
 * - 삭제 버튼 클릭 시 콜백 전달
 */
class MemoAdapter(
    private val onDeleteClicked: (Memo) -> Unit
) : PagingDataAdapter<Memo, MemoAdapter.MemoViewHolder>(diffCallback) {

    /**
     * 뷰 홀더 클래스: ViewBinding을 사용하여 레이아웃 바인딩
     */
    inner class MemoViewHolder(private val binding: ItemMemoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * 데이터 바인딩 함수
         */
        fun bind(memo: Memo) {
            binding.apply {
                itemMemoTitle.text = memo.title
                itemMemoContent.text = memo.content
                itemMemoDate.text = memo.date.toFormattedDateString()

                // 삭제 버튼 클릭 시 외부 콜백 호출
                buttonDeleteMemo.setOnClickListener {
                    onDeleteClicked(memo)
                }
            }
        }
    }

    /**
     * ViewHolder 생성 함수 (레이아웃 inflate)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemoViewHolder {
        val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(binding)
    }

    /**
     * ViewHolder에 데이터 바인딩 수행
     */
    override fun onBindViewHolder(
        holder: MemoViewHolder,
        position: Int
    ) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        /**
         * Paging3에서 리스트 변경 시 효율적으로 차이를 계산해주는 DiffUtil
         */
        val diffCallback = object : DiffUtil.ItemCallback<Memo>() {
            // 아이템 ID가 같으면 같은 항목으로 간주
            override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean =
                oldItem.id == newItem.id

            // 전체 내용이 같으면 UI 업데이트 생략
            override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean =
                oldItem == newItem
        }
    }
}
