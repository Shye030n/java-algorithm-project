package practice.lruCache;

import java.util.HashMap;
import java.util.Map;

public class BasicStructure_02 {
    private final int capacity;
    private final Map<String, Node> map;
    private final DoublyLinkedList dll;


    public BasicStructure_02(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();

    }

    //조회 메서드
    public int access(String city) {
        city = city.toLowerCase();
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

    //순서 관리 클래스
    private static  class DoublyLinkedList {
        private final Node head, tail;

        public DoublyLinkedList() {
            head = new Node(null);
            tail = new Node(null);
            head.next = tail;
            tail.prev = head;
        }
        //최근에 사용한 캐시 head에 저장 메서드
        public void addFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //앞으로 한 칸씩 땡기는 메서드
        public void moveToFront(Node node) {
            remove(node);
            addFront(node);
        }

        // 오래 사용하지 않은 저장 메서드
        public Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        //오래 사용하지 않은 캐시 제거 메서드
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    //1.노드 관리 메서드
    public static class Node {
        String value;
        Node prev, next;
        Node(String value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        BasicStructure_02 bs2 = new BasicStructure_02(cacheSize);
        int totalTime = 0;
        for (String city : cities) {
            totalTime += bs2.access(city);
        }
        System.out.println(totalTime);
    }

}
