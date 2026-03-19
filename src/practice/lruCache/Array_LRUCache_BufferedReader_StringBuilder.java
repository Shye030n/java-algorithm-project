package practice.lruCache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Array_LRUCache_BufferedReader_StringBuilder {
    private int capacity; //캐시의 최대 크기를 저장/제한할 변수
    private List<String> cache; //캐시 데이터를 관리할 ArrayList

    public Array_LRUCache_BufferedReader_StringBuilder(int capacity) { //메인메서드에서 객체를 생성할 때 capacity 값을 받아 초기화.
        this.capacity = capacity; //메인메서드에서 전달받은 capacity 값을 멤버변수에 저장
        this.cache = new ArrayList<>(); //비어있는 ArrayList 를 생성하여, 캐시 저장소로 사용
    }

    public void access(String key) { //캐시에 접근하는 메서드 (특정 키에 접근할 때 호출하는 메서드)
        if (cache.contains(key)) { //캐시에 key가 이미 존재한다면
            cache.remove(key); //해당 위치의 key를 제거하고
            cache.add(0, key); //0번 인덱스 위치에 키를 추가한다.
        } else { //반대 경우
            if(cache.size() == capacity ){ //캐시가 꽉 찬 경우
                cache.remove(capacity - 1); // 캐시 크기 - 1 (가장 뒤에 있는 인덱스)를 제거
            }
            cache.add(0, key); //0번 인덱스에 키를 추가한다.
        }
    }

    public void printCache() { //현재 캐시 상태 출력 메서드
        StringBuilder sb = new StringBuilder(); //문자열을 효율적으로 합치기 위해 StringBuilder 객체 생성
        for (String key : cache) { //배열에 있는 모든 데이터를 전부 순서대로 반복
            sb.append(key + " "); //각 데이터 뒤에 공백을 추가
        }
        System.out.println(sb.toString().trim()); //StringBuilder를 문자열로 변환하고, 뒤에 공백을 제거하여 출력
    }

    public static void main(String[] args) throws IOException {
        /* 입력을 한 줄 단위로 읽는 BufferedReader 객체 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //사용자 입력을 받기 위한 BufferedReader 객체 생성

        System.out.println("캐시 크기를 입력하세요");
        int capacity = Integer.parseInt(br.readLine()); //사용자가 입력한 문자열을 정수형으로 변환하여, capacity 변수에 저장한다.

        /* LRU 캐시를 실제로 처리하는 사용자 정의 클래스 객체 */
        Array_LRUCache_BufferedReader_StringBuilder cache = new Array_LRUCache_BufferedReader_StringBuilder(capacity); //입력받은 capacity로 LRU 캐시 객체를 생성한다.
        System.out.println("도시 이름 배열을 공백으로 구분하여 입력하세요");

        /* 읽은 문자열을 토큰으로 나누는 StringTokenizer 객체 */
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //사용자에게 입력받은 문자열을 공백을 기준으로 토큰화 한다.

        while(st.hasMoreTokens()) { //토큰이 남아있는 동안 반복
            String city = st.nextToken(); //다음 토큰을 city 변수에 저장한다.
            cache.access(city); //특정 키로 캐시에 접근
            cache.printCache(); //현재 캐시 상태 출력
        }
    }
}
