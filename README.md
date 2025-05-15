📝 todo_kotlin
[XML 기반 MVVM 및 싱글 모듈 클린 아키텍처]

# 간단한 메모 작성 및 조회 기능을 제공하는 Android 애플리케이션입니다.
Paging3 + Room 기반 메모 리스트 구현, LiveData 기반 상태 관리, Jetpack Compose 미사용.

## 🚀 데모
홈 화면에서 Floating Action Button (FAB) 클릭 → 메모 즉시 작성

작성된 메모는 최신순으로 정렬되어 목록에 표시됨

메모 리스트는 Paging3 기반 무한 스크롤로 효율적으로 로딩됨

## 🎯 주요 기능
- 메모 추가: FAB 클릭 시 임의 제목/내용을 가진 메모 삽입 (개발 중: 모달/폼 입력)

- 메모 조회: PagingDataAdapter를 통한 최신 메모 리스트 출력

- Room 기반 로컬 저장소: 앱 종료 후에도 데이터 유지

- Paging3 무한 스크롤: 데이터가 많아도 성능 저하 없이 로딩

## 🧱 프로젝트 구조
``` kotlin
com.memo.todo_kotlin
├── data           // Room DAO, Entity, Repository 구현
├── domain         // Model, UseCase, Repository 인터페이스
├── presentation   // View, ViewModel, Adapter, Fragment
├── di             // Hilt 모듈
└── MainActivity   // NavHostFragment 구성
```









