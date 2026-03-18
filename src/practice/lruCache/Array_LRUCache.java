package practice.lruCache;

public class Array_LRUCache {
    private String[] cache; //캐시 배열
    private int capacity; //캐시 크기
    private int size; //현재 저장된 원소 개수

    public Array_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new String[capacity];
        this.size = 0;
    }

    public void access(String key) {
        int pos = find(key);

        if (pos == -1) { //캐시에 없는 경우
            if (size < capacity) {
                shiftRight(size); //맨 앞에 넣기 위해 기존 요소들 뒤로 밀기
                cache[0] = key;
                size++;
            } else {
                shiftRight(capacity -1); //맨 앞에 넣고, 맨 뒤 요소 제거
                cache[0] = key;
            }
        } else { //캐시에 있는 경우
            String temp = cache[pos];
            shiftRight(pos); //해당 위치까지 오른쪽으로 밀기
            cache[0] = temp; // 맨 앞에 배치
        }
    }

    /* 캐시 찾기 */
    private int find(String key) {
        for (int i = 0; i < size; i++) {
            if (cache[i].equals(key)) return i;
        }
        return -1;
    }

    /* 전위에 데이터 추가를 위해 한 칸씩 뒤로 미는 메서드 */
    private void shiftRight(int end) {
        for (int i = end; i > 0; i-- ) {
            cache[i] = cache[i -1];
        }
    }

    public void printCache() {
        for (int i = 0; i < size; i++) {
            System.out.print(cache[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array_LRUCache cache = new Array_LRUCache(3);

        cache.access("SEOUL");
        cache.printCache();

        cache.access("PARIS");
        cache.printCache();

        cache.access("TOKYO");
        cache.printCache();

        cache.access("SEOUL"); //최근 사용 -> 전위 이동
        cache.printCache();

        cache.access("LONDON"); //용량 초과 -> 후위 제거 (가장 오래된 데이터)
        cache.printCache();
    }
}


