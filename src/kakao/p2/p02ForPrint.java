package kakao.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02ForPrint {
    public static void main(String[] args) throws IOException {
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //
        String regex = "(10|[1-9])[SDT][*#]?";

        List<String> tokens;
        tokens = new ArrayList<>();

        String token;
        char readOneToken;

        int score = 0;
        int bonus;

        int finalScore = 0;
        int result;

        int[] scoreArray = new int[3];

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        while (m.find()) {
            tokens.add(m.group());
        }

        for (int i = 0; i < tokens.size(); i++) {
            token = tokens.get(i);
            readOneToken = token.charAt(0);

            if (token.startsWith("10")) {
                score = 10;
            } else {
                score = readOneToken - '0';
            }

            bonus = token.startsWith("10") ? token.charAt(2) : token.charAt(1);

            if(bonus == 'S') {
                finalScore = score;
            }else if( bonus == 'D') {
                finalScore = score * score;
            }else if( bonus == 'T') {
                finalScore = score * score * score;
            }

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

            scoreArray[i] = finalScore;
            System.out.println("-" +"[" + (i) + "] 번째 토큰 : " + scoreArray[i]);

        }
        result = 0;
        for(int s : scoreArray) {
            result = result + s;
        }
        System.out.println("*** 게임 최종 점수 결과는 " + result + " 점 입니다.");
    }
}
