package practice.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUcache01 {
    private Map<Integer, node> nodeMap;
    private int capacity; //최대공간
    private node head;
    private node tail;

    private class node {
        private int key;
        private int value;
        private node prev;
        private node next;

        public node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null; //TODO 노드가 뭔데 널로 생성자를 초기화하는거지?
            /*자료구조에서, 데이터를 담는 하나의 단위 객체를 노드라 한다.*/
        }
    }
    public LRUcache01(int capacity) {
        this.nodeMap = new HashMap<>();
    }
}
