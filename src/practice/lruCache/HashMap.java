package practice.lruCache;

import java.util.Arrays;

public class HashMap<K, V> {
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public HashMap() {
        table = new Entry[capacity];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        Entry<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) table[index] = head.next;
                else prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void clear() {
        Arrays.fill(table, null);
    }

    public int size() {
        int count = 0;
        for (Entry<K, V> e: table) {
            while (e != null) {
                count++;
                e = e.next;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("apple", 1);
        hm.put("banana", 2);
        System.out.println("apple: " + hm.get("apple"));
        System.out.println("contains banana? " + hm.containsKey("banana"));
        hm.remove("apple");
        System.out.println("size: " + hm.size());
    }
}
