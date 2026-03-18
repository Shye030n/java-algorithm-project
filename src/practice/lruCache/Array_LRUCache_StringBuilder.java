package practice.lruCache;

public class Array_LRUCache_StringBuilder {
    private String[] cache; //캐시 데이터를 저장할 문자열 배열
    private int capacity; //캐시의 최대 크기(용량)
    private int size; //현재 캐시에 들어있는 원소 개수

    public Array_LRUCache_StringBuilder(int capacity) { //생성자: 객체를 생성할 때 호출된다. capacity를 받아서 초기화 한다.
        this.capacity = capacity; //전달 받은 capacity 값을 멤버 변수에 저장. //TODO 멤버 변수 개념 되짚기.
        this.cache = new String[capacity]; // capacity 크기의 문자열 배열을 생성.
        this.size = 0; //현재 캐시 크기를 0으로 초기화. //TODO 왜 문자열배열 크기를 두 개를 만드는 거지?
    }

    public void access(String key) { //특정 key(도시 이름)을 캐시에 접근할 때 호출하는 메서드
        int pos = find(key); //key가 캐시에 있는 지 확인하고 위치를 반환

        if (pos == -1) { //캐시가 없는 경우
            if (size == capacity) { //아직 캐시가 꽉 차지 않은 경우
                shiftRight(size); //배열 요소들을 오른쪽으로 밀어 공간을 확보.
                cache[0] = key; //맨 앞(0번 인덱스)에 새로운 key 저장.
                size++; //캐시 크기 증가
            } else { //캐시가 꽉 찬 경우
                shiftRight(capacity-1); //맨 뒤 요소를 밀어내고 공간 확보.
                cache[0] = key; //맨 앞에 새로운 key를 저장.
            }
        } else { //캐시에 이미 존재하는 경우
            String temp = cache[pos]; //해당 위치의 값을 temp에 저장.
            shiftRight(pos); //그 위치까지 오른쪽으로 밀기. //TODO pos가 뭐지?
            cache[0] = temp; //맨 앞에 해당 key를 배치
        }
    }

    private int find(String key) { //key가 캐시에 있는 지 확인하고 위치를 반환
        for (int i = 0; i < size; i++) { // 현재 캐시 크기만큼 반복
            if(cache[i].equals(key)) { //같은 값이면 위치(인덱스) 반환
                return i;
            }
        }
        return -1; // 캐시에 없으면 -1 반환 //TODO 왜 -1 ?
    }

    private void shiftRight(int end) { //end 위치까지 배열을 오른쪽으로 한 칸씩 이동하는 메서드
        for (int i = end; i > 0; i--) { //TODO 이건 또 머야 기준점이 뭐인거지?
            cache[i] = cache[i-1];
        }
    }

    public void printCache() { //현재 캐시 상태를 출력하는 메서드
        StringBuilder sb = new StringBuilder(); //문자를 효율적으로 합치기 위한 객체
        for (int i = 0;  i < size; i++) {
            sb.append(cache[i]).append(" "); //각 원소 뒤에 공백 붙여서 추가
        }
        System.out.println(sb.toString().trim()); //뒤에 공백을 제거하여 문자열 출력
    }

    public static void main(String[] args) { //프로그램 실행 시작점
        int capacity = 3;
        String[] cities = {"SEOUL", "JEJU", "BUSAN", "JEJU", "INCHEON"};

        Array_LRUCache_StringBuilder cache = new Array_LRUCache_StringBuilder(capacity); //객체 생성

        for (String city : cities) { //배열의 각 도시 이름에 대해 반복
            cache.access(city); //해당 도시를 캐시에 접근
            cache.printCache(); //현재 캐시상태 출력
        }

    }
}
