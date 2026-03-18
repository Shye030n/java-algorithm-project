package practice.lruCache;

import java.util.HashMap;
import java.util.Map;

public class StandardSolution_LRUCache {

    class Node {

        String key;
        Node prev;
        Node next;

        Node(String key) {
            this.key = key;
        }
    }

    private int capacity;
    private Map<String, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    public StandardSolution_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private void remove(Node node) { //노드 제거 메서드

        if (node.prev != null) { //이전 노드가 있는 경우 = 현재 데이터가 head가 아니면
            node.prev.next = node.next; //현재 노드의 이전의 다음 = 기존 노드의 다음 노드다
        } else { //이전 노드가 없는 경우 = head 라면
            head = node.next;
            //TODO 여기 이해가 안돼. head = node 아닌가?
            // ㄴ 이유 : head는 삭제한 노드를 가리키면 안 되므로, 그 다음 노드가 새로운 head가 됨.
        }

        if (node.next != null) { //다음 노드가 있는 경우 = tail이 아니면
            node.next.prev = node.prev; //현재 노드 다음의 이전 = 현재노드의 이전
        } else { //다음 노드가 없는 경우 = tail 이면
            tail = node.prev;
            // TODO : 여기도 이해가 안가. tail = node 아닌가?
            //  ㄴ 이유:  tail 도 마찬가지로 삭제된 노드를 가리키면 안되기에, 이전 노드가 새로운 tail 이 됨.
        }
    }

    private void addFirst(Node node) { //전위 데이터 추가 메서드
        node.next = head;
        node.prev = null;

        if (head != null) { //head에 값이 있다면
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
    }

    /*
    * access(key) 메서드 호출 시
    * 이미 존재 -> 맨 앞으로 이동
    * 없으면 -> 새 노드 추가
    *   ㄴ 용량 초과 시 tail 제거
    */
    public void access(String key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addFirst(node);
        } else {
            Node node = new Node(key);

            if(map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
            }

            addFirst(node);
            map.put(key, node);
        }
    }

    public void printCache() {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StandardSolution_LRUCache cache = new StandardSolution_LRUCache(3);
        cache.access("SEOUL");
        cache.printCache(); //현재 캐시 상태 확인

        cache.access("PARIS");
        cache.printCache();

        cache.access("TOKYO");
        cache.printCache();

        cache.access("SEOUL");
        cache.printCache();

        cache.access("LONDON");
        cache.printCache();
    }
}
