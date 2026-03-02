# HashMap

###  기본 구조

- 내부적으로 배열 + 해시 함수 + 버킷(체이닝 또는 트리) 구조를 사용.
- key -> 해시 함수 -> 인덱스 -> Value 저장
- 충돌 시 LinkedList 또는 TreeNode로 관리. 

### 장점

- 평균적으로 O(1) 조회/삽입/삭제
- K-V 매핑 구조로 직관적
- null key 와 null value 허용

### 단점
- 순서 없음 (순서 필요하면 LinkedHashMap 사용)
- 해시 충돌 시 성능 저하 가능
- 메모리 사용량이 배열 + 노드 구조라 상대적으로 큼

### 주요 API
- put(K key, V value) : 값 삽입
- get(Object key) : 값 조회
- remove(Object key) : 값 삭제
- containsKey(Object key) : 키 존재 여부 확인
- size() : 요소 개수
- clear() : 전체 삭제