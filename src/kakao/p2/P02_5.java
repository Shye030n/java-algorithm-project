package kakao.p2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_5 {
    public static void main(String[] args) {
        //입력
        String one = "1S2D*3T"; //37

        //처리
        String regex =  "([1-9]|10)[SDT][*#]?";

        Pattern p = Pattern.compile(regex); //정규식 컴파일
        Matcher m = p.matcher(one); //정규식 적용

        while (m.find()) { //전체 토큰 출력
            System.out.println(m.group());
        }
    }
}
