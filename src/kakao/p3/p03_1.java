package kakao.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
* TODO : 캐시의 중간에서 cacheHit인 경우, 처리 로직 추가 필요
*/

public class p03_1 {
    private int cacheSize; //캐시 크기
    private ArrayList<String> cities; //도시 이름 배열

    public int total;

    public p03_1(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cities = new ArrayList<>();
        this.total = 0;
    }

    public void access(String city) {
        if(cacheSize == 0) { //cacheSize == 0
            total += 5;
            System.out.println("캐시가 0인경우: "+ cities);
            return; //더 이상 로직 진행하지 않음
        }

        if (cities.contains(city)) { //cacheHit
            cities.remove(city); //여기가 먼가 이상한데
            System.out.println("-----제거된 캐시 상태 : " + cities);
            //TODO 여기서 제일 마지막 인덱스는 지웠는데, 앞에 서울, 팡요는 한 칸씩 뒤로 가야 해
            cities.add(0, city);
            System.out.println("cacheHit인 경우: "+ cities);
            total += 1;
        } else { //cacheMiss
            if(cities.size() == cacheSize) {
                cities.remove(cacheSize - 1);
                System.out.println(cacheSize);
                System.out.println("cacheMiss인 경우 remove : " + cities);
            }
            cities.add(0, city);
            System.out.println("cacheMiss인 경우 add : " + cities + city);
            total += 5;
        }
    }
    //캐시의 중간에서 cacheHit이 발생했을 때, 한 칸씩 앞으로 당길 메서드
    //만약 캐시가 cacheSize[0] 혹은 cacheSize-1이 아닌 경우 //즉 중간에서 빼내는 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cacheSize = Integer.parseInt(br.readLine());
        //여기서, 캐시 사이즈 입력
        p03_1 lru = new p03_1(cacheSize);
        //여기서, 도시 이름 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), ",[]\u201C\u201D "); //StringTokenizer는 두 번째 파라미터로 쌍따옴표 안에 있는 모든 문자들을 구분자로 인식 “”
        while (st.hasMoreTokens()) { //전체 토큰 반복
            String city = st.nextToken().toUpperCase(); //다음 토큰을 모두 대문자로 변환하여, 문자열 변수 city에 저장
            lru.access(city);
            System.out.println("씨티 : " + city);
            System.out.print(city + "를 조회 -> ");
        }
        System.out.println();
        System.out.println("실행 시간 : " + lru.total);
        System.out.println("마지막 캐시 상태: " + lru.cities); //TODO 가운데가 비어있음. 이 말은 중간에서 데이터를 빼낸 인덱스가 공백으로 유지되는 상태인 거 같다
    }
}
