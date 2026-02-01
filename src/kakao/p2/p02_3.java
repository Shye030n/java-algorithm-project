package kakao.p2;

public class p02_3 {/* kakao HINT
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


        int score = 0; //점수 계산 저장소

        String[] tokens; //분리된 문자열 저장소

        //처리
        tokens = one.split("^[1-9]"); // 1~9로 시작하는 부분을 구분자로 지정하여 tokens에 저장
        for(int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
        //System.out.println(tokens.length);
        //System.out.println(tokens[0]);
        //System.out.println(tokens[1]);
        //System.out.println(tokens[2]);
        //    System.out.println(tokens[i]);





        //출력
    }
}
