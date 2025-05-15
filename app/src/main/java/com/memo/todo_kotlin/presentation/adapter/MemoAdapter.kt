package com.memo.todo_kotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.memo.todo_kotlin.databinding.ItemMemoBinding
import com.memo.todo_kotlin.domain.model.Memo
import com.memo.todo_kotlin.presentation.util.toFormattedDateString

class MemoAdapter(
    private val onDeleteClicked: (Memo) -> Unit
) : PagingDataAdapter<Memo, MemoAdapter.MemoViewHolder>(diffCallback) {

    inner class MemoViewHolder(private val binding: ItemMemoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(memo: Memo) {
            binding.apply {
                itemMemoTitle.text = memo.title
                itemMemoContent.text = memo.content
                itemMemoDate.text = memo.date.toFormattedDateString()

                buttonDeleteMemo.setOnClickListener {
                    onDeleteClicked(memo)
                }
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemoViewHolder {
        val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MemoViewHolder,
        position: Int
    ) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Memo>() {
            override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean = oldItem == newItem
        }
    }
}