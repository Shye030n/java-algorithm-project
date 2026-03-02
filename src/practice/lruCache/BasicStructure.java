package practice.lruCache;

import java.util.HashMap;
import java.util.Map;

/*
* LRU Cache 시뮬레이션을 구현하는 기본 뼈대.
* 코딩 테스트에서 자주 나오는 패턴
* HashMap 으로 빠른 조회, DoubleLinkedList 로 순서 관리 가 핵심
* */
public class BasicStructure {
    private final int capacity;
    private final Map<String, Node> map;
    private final DoublyLinkedList dll;

    public BasicStructure(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int access(String city) {
        city = city.toLowerCase(); //대소문자 구분 없애기
        if (map.containsKey(city)) {
            Node node = map.get(city);
            dll.addFront(node);
            return 1;
        } else {
            Node newNode = new Node(city);
            dll.addFront(newNode);
            map.put(city, newNode);

            if (map.size() > capacity) {
                Node lru = dll.removeLast();
                map.remove(lru.value);
            }
            return 5;
        }
    }

    private static class DoublyLinkedList {
        private final Node head, tail;

        public DoublyLinkedList() {
            head = new Node(null);
            tail = new Node(null);
            head.next = tail;
            tail.prev = head;
        }

        public void addFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToFront(Node node) {
            remove(node);
            addFront(node);
        }

        public Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    public static class Node {
        String value;
        Node prev, next;
        Node(String value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities
//                = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
//                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//                = {"Jeju", "Pangyo", "Seoul",
//                "Jeju", "Pangyo", "Seoul",
//                "Jeju", "Pangyo", "Seoul"};
            = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        BasicStructure cache = new  BasicStructure(cacheSize);
        int totalTime = 0;
        for (String city : cities) {
            totalTime += cache.access(city);
        }
        System.out.println("총 실행 시간은, ["+ totalTime + "] 입니다.");
    }
}
