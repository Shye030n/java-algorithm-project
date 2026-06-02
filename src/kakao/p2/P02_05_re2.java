package kakao.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_05_re2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); //사용자 입력을 한 줄 단위로 input 변수에 저장

        String regex = "(10|[1-9])[SDT][*#]?"; //정규식 생성

        List<String> tokens = new ArrayList<>(); //토큰들 저장할 배열 생성
        String token; //현재 처리할 토큰
        char readOneToken; //한 글자씩 읽을 객체

        int score = 0; //점수 저장 변수 및 초기화
        int bonus; //보너스 문자 (SDT) 저장할 변수
        int finalScore = 0; //최종 출력할 점수
        int result; //전체 합산 결과 점수
        int[] scoreArray = new int[3]; //각 라운드 점수 저장할 배열(총 기회 3번)

        Pattern pattern = Pattern.compile(regex); //정규식 패턴을 컴파일할, 패턴 객체 생성
        Matcher matcher = pattern.matcher(input); //입력 문자열에 대해 정규식을 매칭할, 매처 객체 생성



    }
}
