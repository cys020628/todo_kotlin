package com.memo.todo_kotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room에서 사용하는 SQLite 데이터베이스 정의 클래스.
 *
 * ▷ 주요 설명:
 * - `@Database`: Room이 이 클래스가 데이터베이스임을 인식하게 함.
 * - `entities = [...]`: 이 데이터베이스가 어떤 테이블(Entity)을 포함하는지 명시.
 * - `version = 1`: DB 스키마 버전 (마이그레이션 시 필수).
 * - `RoomDatabase`를 상속받아 실제 DB 접근 API를 제공.
 * - `abstract fun memoDao()`: 이 DB에서 사용할 DAO(Data Access Object) 제공 함수.
 *
 * ▷ 왜 이렇게 작성해야 하는가?
 * - Room은 내부적으로 Annotation Processing(KAPT 또는 KSP)을 사용해
 *   해당 클래스 기반으로 `RoomDatabase_Impl` 코드를 자동 생성함.
 * - 추상 클래스로 정의해야 Room이 컴파일 타임에 필요한 구현체를 생성할 수 있음.
 */
@Database(
    entities = [MemoEntity::class], // 이 데이터베이스에 포함될 테이블 클래스 목록
    version = 1                     // DB 스키마 버전 (버전이 올라가면 마이그레이션 필요)
)
abstract class MemoDatabase : RoomDatabase() {

    /**
     * 메모 관련 DB 작업을 수행할 DAO 객체를 반환하는 추상 함수.
     * Room이 이 함수명과 반환 타입을 기준으로 구현체를 자동 생성함.
     */
    abstract fun memoDao(): MemoDao
}
