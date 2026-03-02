package practice;

import java.util.regex.Pattern;

public class StringClass_Regex2 {
    public static void main(String[] args) {
        String patternString = "^[0-9]*$"; //숫자만 입력받는 패턴
        //Pattern pattern = Pattern.compile(patternString); //Pattern 클래스 객체로 정규식 컴파일

        //샘플 문자열
        String txt1 = "123456";
        String txt2 = "1이히히6a";

        boolean result1 = Pattern.matches(patternString, txt1);
        boolean result2 = Pattern.matches(patternString, txt2);
        System.out.println("result1 는 " + result1);
        System.out.println("result2 는 " + result2);

    }
}
