package practice.lruCache;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* BufferedReader : 입력을 한 줄 단위로 빠르게 읽음
* StringTokenizer : 읽은 문자열을 공백 기준으로 토큰화해서 하나씩 꺼냄
* ArrayList : 캐시를 관리하면서 LRU 로직 구현
* String Builder : 출력 문자열을 효율적으로 합침
*/

/*
* 전체 흐름 )
* 입력 : BufferedReader로 한 줄 읽음
* 분리 : StringTokenizer로 공백 기준 토큰화
* 처리 : 각 토큰을 cache.access(city)로 LRU 캐시에 반영
* 출력 : printCache()에서 StringBuilder로 문자열 합쳐서 출력
*/
public class Array_LRUCache_BufferedReader_StringTokenizer {
    private int capacity; //캐시의 최대 크기를 저장할 변수
    private List<String> cache; //문자열 캐시 데이터를 관리할 ArrayList

    public Array_LRUCache_BufferedReader_StringTokenizer(int capacity) { //객체를 만들 때 capacity 값을 받아 초기화.
        this.capacity = capacity;
        this. cache = new ArrayList<>();
    }
    public void access(String key) { //특정 key(도시 이름)에 접근할 때 호출하는 메서드
        if (cache.contains(key)) { //cacheHit
            cache.remove(key); //기존 캐시 데이터에서 제거
            cache.add(0, key); //0번 인덱스에 추가
        } else { //cacheMiss
            if (cache.size() == capacity) {
                cache.remove(capacity - 1); //마지막 인덱스 제거
            }
            cache.add(0, key);
        }
    }

    public void printCache() {
        StringBuilder sb = new StringBuilder(); //문자열을 효율적으로 합치기 위한 StringBuilder 객체 생성
        for (String city : cache) { //캐시에 있는 모든 데이터를 순차적으로 꺼냄
            sb.append(city).append(" "); //각 도시 이름 뒤에 공백을 붙여 추가
        }
        System.out.print(sb.toString().trim()); //StringBuilder를 문자열로 변환하고, 뒤 공백을 제거한 후 출력
    }

    public static void main(String[] args) throws IOException { //프로그램 시작점
        // IOException?, main 메서드에서 BufferedReader로 입력받을 때 "입출력 예외"가 발생할 수 있으므로 throws로 선언해둠
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //사용자 입력값을 한 줄씩 읽을 객체 생성

        System.out.print("제한할 캐시 크기를 입력하세요.");
        int capacity = Integer.parseInt(br.readLine()); //한 줄 씩 읽은 문자열을 정수형으로 변환하여 capacity 변수에 저장

        Array_LRUCache_BufferedReader_StringTokenizer cache = new Array_LRUCache_BufferedReader_StringTokenizer(capacity); //LRU 처리 객체 생성

        System.out.print("도시 이름을 공백으로 구분하여 입력하세요.");
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백을 구분자로 하여 토큰화
        while (st.hasMoreTokens()) { //남은 토큰이 없어질 때까지 계속 반복
            String city = st.nextToken(); //다음 토큰을 문자열 변수 city에 저장.
            cache.access(city); //access 메서드로 city를 캐시에 접근
            cache.printCache(); //현재 캐시 상태 출력
        }


    }
}
