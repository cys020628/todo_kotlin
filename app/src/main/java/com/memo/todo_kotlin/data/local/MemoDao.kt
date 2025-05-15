package com.memo.todo_kotlin.data.local

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MemoDao {

    /**
     * 전체 메모를 최신순으로 정렬하여 실시간 스트림(Flow)으로 반환
     * 메모 추가/삭제 시 자동 갱신됨
     */
    @Query("SELECT * FROM memotable ORDER BY memoDate DESC")
    fun getAllMemos(): LiveData<List<MemoEntity>>

    /**
     * 메모를 추가 또는 수정함
     * 같은 memoId가 있으면 업데이트, 없으면 삽입됨 (Room 2.4 이상)
     */
    @Upsert
    suspend fun upsertMemo(memo: MemoEntity)

    /**
     * 메모 한 건을 삭제
     */
    @Delete
    suspend fun deleteMemo(memo: MemoEntity)

    /**
     * 특정 ID에 해당하는 메모 한 건을 조회
     */
    @Query("SELECT * FROM memotable WHERE memoId = :id")
    suspend fun getMemoById(id: Long): MemoEntity?

    /**
     * 전체 메모를 최신순으로 정렬한 PagingSource 반환
     * Paging3 라이브러리에서 사용됨
     */
    @Query("SELECT * FROM memotable ORDER BY memoDate DESC")
    fun getAllMemosPaging(): PagingSource<Int, MemoEntity>
}
