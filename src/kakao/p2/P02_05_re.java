package kakao.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_05_re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //사용자 입력을 한 줄 단위로 읽어낼 객체 생성
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

        while (matcher.find()) { //입력 문자열에서 정규식과 일치하는 부분을 찾을 때마다 반복
            tokens.add(matcher.group()); //매칭된 문자열(토큰)을 리스트에 추가
        }

        for(int i = 0; i < tokens.size(); i++) { //토큰 리스트를 순서대로 반복
            token = tokens.get(i); //현재 토큰 가져옴
            readOneToken = token.charAt(0);

            if(token.startsWith("10")) { //10으로 시작하는 경우
                score = 10;
            } else {
                score = readOneToken - '0'; //첫 글자를 숫자로 변환하여 점수로 설정
            }

            bonus = token.startsWith("10") ? token.charAt(2) : token.charAt(1); //10일 경우 보너스 문자는 세번째 글자, 그 외에는 두 번재 글자

            if(bonus =='S') {
                finalScore = score;
            } else if (bonus =='D') {
                finalScore = score * score;
            } else if (bonus =='T') {
                finalScore = score * score * score;
            }

            if(token.endsWith("*")) {
                finalScore = finalScore * 2;
                if( i > 0) {
                    scoreArray[i-1] = scoreArray[i-1] * 2; //이전 점수도 두 배
                }
            } else if(token.endsWith("#")) {
                finalScore = finalScore * -1; //현재 점수를 음수로 변환
            } else {
                finalScore = finalScore; //옵션 없으면 그대로 ㅠㅇ지
            }

            scoreArray[i] = finalScore; //최종 점수를 배열에 저장
            System.out.println("-" +"[" + (i) + "] 번째 토큰 : " + scoreArray[i]);
        }

        result = 0; //최종 점수 초기화
        for(int s : scoreArray) { //배열의 모든 점수를 순회하며
            result = result + s; //합산
        }
        System.out.println("*** 게임 최종 점수 결과는 " + result + " 점 입니다.");



    }
}
