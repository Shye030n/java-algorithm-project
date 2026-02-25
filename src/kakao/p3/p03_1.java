package kakao.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_1 {
    public static void main(String[] args) throws IOException {
        /*
        * 입력
        * 캐시 크기 : 0 이상, 30 이하
        * 도시 이름 배열 : 100,000 개 이하, 순수 영문자로 대소문자 구분하지 않음. 도시 이름 최대 길이 20자
        */
        int cacheSize;
        String[] cities;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cacheSize = Integer.parseInt(br.readLine()); //캐시크기 입력(String -> int)
        System.out.println(cacheSize);

        cities = new String[]{br.readLine()}; //도시이름배열 입력 (String -> String[]) //TODO 지금 배열로 입력한 도시이름들 전체를 cities의 원소 하나로 인식하고 있음
        System.out.println(cities[0]);


        /*
        * 처리
        * LRU
        * cache hit 인 경우, 1
        * cache miss 인 경우, 5
        */


        /*
        * 출력
        * 입력된 도시 이름 배열을 순서대로 처리하여, "총 실행시간"을 출력한다.
        */
    }
}
