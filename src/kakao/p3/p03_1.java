package kakao.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
            return; //더 이상 로직 진행하지 않음
        }

        if (cities.contains(city)) { //cacheHit
            cities.remove(city);
            cities.add(0, city);
            total += 1;
        } else { //cacheMiss
            if(cities.size() == cacheSize) {
                cities.remove(cacheSize - 1);
                System.out.println(cacheSize);
            }
            cities.add(0, city);
            total += 5;
        }
    }

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
        }
        System.out.println();
        System.out.println("실행 시간 : " + lru.total);
    }
}
