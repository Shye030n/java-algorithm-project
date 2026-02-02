package kakao.p2;

public class p02_3 {/* kakao HINT
 * - String Manipulation
 * - Tokenizing
 * - Semantic Analysis
 * - Regular Expression
 * */
    //결론, split을 이용해서 문자열을 세 묶음으로 자르려고 시도했으나, 하나씩 꺼내서 배열로 저장하고 출력하는 방법으로 해야함.


    public static void main(String[] args) {

        //입력
        String one = "1S2D*3T"; //37
        //String two = "1D2S#10S"; //9
        //String three = "1D2S0T"; //3

        String[] tokens; //분리된 문자열 저장소
        String token; //분리된 문자

        int a; //득점
        int b; //보너스
        int c; //옵션


        int score = 0; //점수 계산 저장소

//        int stringToInt(String str  ){
//            return;
//        }

        //처리
        tokens = one.split(""); // 하나씩 잘라서 배열에 넣음 //근데 이것보다 정규식으로 바로 자르는게 좋을듯
        for(int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]); //하나씩 잘라내서 배열에 저장 완료 //왜?
            token = tokens[i];
            System.out.println(token);
            if(token.equals("[/d]")) {
                //score = ;
            }else if(token.equals("[/w]")) {

            }else if(token.equals("[\\#|\\*]")) {

            } else return;




        }
        //출력
        //score = a*b*c

    }
}
