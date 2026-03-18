package practice.lruCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array_LRUCache_StringBuilder_Scanner {
    private int capacity; //캐시 크기를 저장하는 정수형 변수
    private List<String> cache; // 캐시 데이터를 관리할 문자열 ArrayList

    public Array_LRUCache_StringBuilder_Scanner(int capacity) { //capacity를 받아서 초기화하는 생성자, 메인메서드에서 객체 생성시 호출됨
        this.capacity = capacity; //메인메서드에서 전달받은 capacity 값을 멤버 변수에 저장.
        this.cache = new ArrayList<>(); //비어있는 ArrayList 생성
    }

    public void access(String key) { //특정 key(도시 이름)로 캐시에 접근할 때 호출
        if (cache.contains(key)) { //캐시에 이미 존재하는 경우
            cache.remove(key); //캐시에 있는 해당 key를 제거
            cache.add(0, key); //0번 인덱스에 추가
        } else { //캐시에 없는 경우
            if (cache.size() == capacity) { //캐시가 꽉 찬 경우
                cache.remove(capacity - 1); //가장 오래된 데이터 제거하여 캐시 사이즈 맞춤
            }
            cache.add(0, key); // 0번 인덱스에 key(데이터) 추가
        }
    }
    public void printCache() { //현재 캐시 상태 출력 메서드
        StringBuilder sb = new StringBuilder(); //문자열을 효율적으로 합치기 위한 StringBuilder 객체 생성
        for (String city : cache) { //캐시에 있는 모든 데이터를 하나씩 다 꺼냄
            sb.append(city).append(" "); //각 도시 이름 뒤에 공백을 붙여서 StringBuilder에 추가 //TODO .append()
        }
        System.out.println(sb.toString().trim()); //StringBuilder로 문자열 자른 후 공백 제거한 것을 출력
    }

    public static void main(String[] args) { //프로그램 실행 시작점
        /*
        * Scanner를 쓰는 이유, 간단한 구조. nextInt(), nextline() 같은 메서드로 원하는 타입을 얻을 수 있음
        *  하지만, BufferdReader에 비해 상대적으로 느리고, 입력 파싱 과정에서 오버헤드가 있기에, 실무에서는 잘 사용하지 않는다.
        *         BufferdReader는 입력의 한 줄 단위로 빠르게 읽어냄.
        *
        * StringBuilder 란, 이미 받은 문자열을 효율적으로 가공하는 도구
        */
        Scanner sc = new Scanner(System.in); //사용자 입력을 받기 위한 Scanner 객체 생성
        int capacity = sc.nextInt(); //입력받은 정수를 capacity 변수에 저장 (캐시 크기 설정)
        sc.nextLine(); //버퍼 비우기 (줄바꿈 문자 제거)

        Array_LRUCache_StringBuilder_Scanner cache = new Array_LRUCache_StringBuilder_Scanner(capacity); //입력받은 capacity로 LRU 캐시 객체 생성
        StringBuilder sb = new StringBuilder(sc.nextLine()); //입력받은 문자열을 StringBuilder에 저장
        String[] cities = sb.toString().split(" "); //StringBuilder를 문자열로 변환 후 공백 기준으로 나눠, 배열에 저장

        for (String city : cities) { //cities 전체 순환
            cache.access(city); //도시를 캐시에 접근
            cache.printCache(); //현재 캐시 상태 출력
        }
        sc.close(); //객체 닫기(자원 해제)
    }
}
