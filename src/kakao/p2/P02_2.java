package kakao.p2;

import java.util.StringTokenizer;

public class P02_2 {
    /* kakao HINT
    * - String Manipulation
    * - Tokenizing
    * - Semantic Analysis
    * - Regular Expression
    * */
    public static void main(String[] args) {
        //입력
        String one = "1S2D*3T"; //37
        //String two = "1D2S#10S"; //9
        //String three = "1D2S0T"; //3


        //처리

        //정규식으로 구분자를 설정
        /*
        * 정규식을 메서드로 지정하는 방법은
        * java.util.regex 패키지의 Pattern과 Matcher 클래스를 사용하는 방법이 있다.
        * */

        StringTokenizer st = new StringTokenizer(one, "delim", true);

        System.out.println("[계산할 문자열] : " + one);
        System.out.println("[토큰 총 수량] : " + st.countTokens()); //현재 나눠진 토큰 개수 : 2가 아니라 3이 나와야지

        // TODO 현재 문제점, 토큰의 구분자 잡는 걸 못하는중

        //토큰이 남아있는 동안 반복 = 토큰 전체
        while (st.hasMoreTokens()) {
            System.out.println("[남은 토큰 개수] : " + st.countTokens());
            String token = st.nextToken();

            if(token.equals(",")) {
                //토큰 뒤에 구분자 붙이는 로직
            }

            System.out.println("[현재 토큰] : "+ token);

        }

        //출력


    }
}
