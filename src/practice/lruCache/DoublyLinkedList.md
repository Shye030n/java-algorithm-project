# DoublyLinkedList

### 기본 구조

- 각 노드(Node)가 데이터 + prev + next 포인터를 가짐.
- Head <-> Node <-> Tail 구조로 양방향 연결
````java
class Node {
    int data;
    Node prev;
    Node next;
    Node (int data) {
        this.data = data;
    }
}
````
### 주요 API

- **addFirst(Node node) : 맨 앞 삽입**
- **addLast(Node node) : 맨 뒤 삽입**
- **remove(Node node) : 특정 노드 삭제**
- **moveToFront(Node node) : 노드를 맨 앞으로 이동**
- **removeLast() : 맨 뒤 노드 삭제**

---

### 장점

- 양방향 탐색 가능
- 삽입/삭제가 O(1) (노트 참조만 있다면)
- Queue, Deque(덱) 같은 자료구조 구현에 적합

### 단점

- 포인터(prev, next) 때문에 메모리 사용량 증가
- 배열처럼 이덱스로 접근 불가. 탐색은O(n)
- 구현 난이도가 단순 LinkedList 보다 높음

---
## LinkedList

### 연결 리스트의 기본 구조
*Node, Head, Tail로 구성*
- Node : "데이터 + 다음 노드를 가리키는 포인터(=참조 =reference)"
- Head : 리스트의 첫 번째 노드
- Tail : 리스트의 마지막 노드

### 주요 API
*LinkedList<E> 클래스는 이중 연결 리스트 기반으로 다음과 같다.*

- 삽입
  - Add(E e) 또는 addLast(E e) : 맨 뒤에 삽입
  - addFirst(E e) : 맨 앞에 삽입
  - add(int index, E e) : 특정 위치에 삽입
- 삭제
  - remove() : 맨 앞 요소 삭제
  - removeFirst : 앞 요소 삭제
  - removeLast() : 뒷 요소 삭제
  - clear() : 전체 삭제
- 조회
  - get(int index) : 특정 위치 요소 반환
  - getFirst() : 앞 요소 반환
  - getLast() : 뒷 요소 반환
  - contains(Object o) : 요소 포함 여부 확인
  - size() : 요소 개수 반환
- 순회
  - interator() : 순차 탐색
  - descendingIterator : 거꾸로 탐색


### 종류

- SinglyLinkedList : 단일 연결 리스트 (data + next)
- DoublyLinkedList : 양방향 연결 리스트 (data + prev + next)
- CircularLinkedList : 원형 연결 리스트

### 중요한 특징

- 비연속적 메모리 : 배열은 연속된 메모리에 저장되지만, 연결 리스트는 흩어진 메모리를 포인터로 연결한다.
- 동적 크기 : 필요할 때마다 노드를 추가/삭제 가능
- 양방향 탐색 가능 : DoublyLinkedList의 prev, next로 앞 뒤 이동
- 캐시 효율 낮음 : 배열은 CPU 캐시 친화적이지만, 연결리스트는 메모리 접근이 분산되어 성능 저하 가능

### 장점
*동적 크기와 빠른 삽입/삭제가 강점, 접근이 느리고 메모리 사용량이 많은게 단점*

| 특징 | 장점                           | 단점 |
|-----|------------------------------|------|
| 메모리구조 | 동적 크기 조절 가능(배열과 반대)          | 포인터 저장으로 메모리 사용량 증가 |
| 데이터 삽입/삭제 | 특정 노드를 알고 있으면 O(1)           | 임의 접근 불가로 탐색은 O(n) |
| 순서 관리 | 노드 연결로 유연한 구조                | 캐시 지역성(Locality) 낮음, CPU 성능 저하 가능 |
| 구현 난이도 | 스택, 큐, 덱 구현에 다양하게 변형하여 활용 하능 | 배열보다 구현이 복잡 |



