package kakao.p3;

import practice.lruCache.HashMap;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class p03_1 {
    public static void main(String[] args) throws IOException {
        /*
        * 입력
        * 캐시 크기 : 0 이상, 30 이하
        * 도시 이름 배열 : 100,000 개 이하, 순수 영문자로 대소문자 구분하지 않음. 도시 이름 최대 길이 20자
        */
        int cacheSize=3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        int totalTime; // 총 실행 시간

        /*
        * 전 처리
        */
        //대소문자 구분 X => 전체 대문자로 변환해서 저장.
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
            System.out.println(cities[i]); //각 원소별로 대문자로 저장 및 출력 완료
        }
        System.out.println(Arrays.toString(cities)); //cities 배열의 모든 원소를, 문자열로 변환.

        /*
        * 이제, 캐시사이즈 만큼 연결리스트로 LRU 초기 처리를 해야하는데,
        * 아니지. 처음부터 cassMiss로 가면 되는거 아니야? ㅇㅇㅇㅇㅇㅇㅇㅇ
        * 그럼 반복문을 돌아. cities 배열의 길이 만큼.
        * 돌면서, cacheHit =1, cacheMiss=5 처리를 해.         ( <--- 진행도 )
        * cacheHit인 경우에는 토탈시간에 +1하고,
        * Miss인 경우에 캐시 저장소에 전위에 데이터를 추가하는.
        *   그리고 만약에 캐시저장소의 길이가 캐시사이즈를 넘는 경우(+1) 가장 후위 데이터를 하나 지운다.
        */


        //캐시 저장용
        LinkedList<Object> lruCache = new LinkedList<>();
        //캐시 조회용
        HashMap cacheInquiry;

        /*
        * 출력
        */



    }
}
