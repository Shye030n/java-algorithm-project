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


