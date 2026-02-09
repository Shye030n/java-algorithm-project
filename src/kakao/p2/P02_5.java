package kakao.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_5 {
    public static void main(String[] args) {
        //입력
        String one = "1S2D*3T"; //37
//        String one = "1D2S#10S";

        //처리
        String regex = "([1-9]|10)[SDT][*#]?"; //정규식

        List<String> tokens; //전체 토큰 {3}
        tokens = new ArrayList<>();

        String token; //토큰
        char readOneToken; //하나씩 읽기

        int score = 0;// 점수 계산 시작점
        int bonus; // 보너스

        int[] scoreArray = new int[3]; //토큰 별 점수

        int finalScore = 0; //최종 점수
        int result; //출력용 최종 점수 합계

        //정규식 생성
        Pattern p = Pattern.compile(regex); //정규식 컴파일
        Matcher m = p.matcher(one); //정규식 적용

        //조건에 따라 토큰에 저장
        while (m.find()) {
            //System.out.println(m.group());
            tokens.add(m.group()); //토큰 저장
        }

        for (int i = 0; i < tokens.size(); i++) {
            // 한 글자씩 잘라서 읽기
            token = tokens.get(i);
            readOneToken = token.charAt(i);

            //점수,보너스,옵션에 나눠서 처리

            //점수 처리
            if (token.startsWith("10")) { //10인 경우
                score = 10;
            } else { //1-9인 경우
                score = readOneToken - '0';
            }

            //보너스 처리
            bonus = token.startsWith("10") ? token.charAt(2) : token.charAt(1);

            if(bonus == 'S') {
                finalScore = score;
            }else if( bonus == 'D') {
                finalScore = score * score;
            }else if( bonus == 'T') {
                finalScore = score * score * score;
            }

            //옵션 처리;
            if(token.endsWith("*")){
                finalScore = finalScore * 2;
                if(i > 0){
                    scoreArray[i-1] = scoreArray[i-1] * 2;
                }
            } else if(token.endsWith("#")){
                finalScore = finalScore * -1;
            } else {
                finalScore = finalScore;
            }

            System.out.println("-" +"[" + (i) + "] 번째 토큰 : " + finalScore);

        }
        //출력
        result = 0;
        for(int s : scoreArray) {
            result += s;
        }
        System.out.println("*** 게임 최종 점수 결과" + result);
    }
}
