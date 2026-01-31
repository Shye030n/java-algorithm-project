package kakao.p2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P02_1 {
    /*
    * P02_다트게임
    * 다트 게임은 총 3회로 구성 => 반복문으로 3번 반복 (1~10)
    * 점수와 함께 S,D,T 3가지 영역이 존재. 각 ^1, ^2, ^3, (점수마다 무조건 하나씩 적용)
    * 옵션으로 *스타상: 해당 차례와, 해당 차례 전의 점수X2, #아차상: *-1 (0,1개만 가능)
    * 1회에서 스타상이 나온 경우는 1회만 적용
    * *과 #의 효과는 중첩 가능 충첩시 *-2
    * */
    public static void main(String[] args) {
        //입력
        String one = "1S2D*3T"; //37

/*
        String two = "1D2S#10S"; //9
        String three = "1D2S0T"; //3
        String four = "1S*2T*3S"; //23
        String five = "1D#2S*3S"; //5
        String six = "1T2D3D#"; //-4
        String seven = "1D2S3T*"; //59
*/
        //처리
        /*
        * A + B + C => 무조건 3번 더함
        * (SDT) 스위치케이스와 enum으로? 3번 반복
        * */

        //읽을 문자열 저장소
        String scoreString;
        // 계산할 점수 결과 저장소
        int scoreInt = 0;

        //보너스 영역
        enum Bonus {
            S,
            D,
            T
        }
        Bonus bonus;
        bonus = Bonus.S;

        //계산할 문자열 받아옴
        scoreString = one;

        //문자열 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("계산할 문자열: " + scoreString);

        // 한 글자씩 읽기 시작
        for (int j = 0; j < scoreString.length(); j++) { //1~10

            //한 글자씩 읽을 변수
            char readOne;
            //System.out.println("readOne : " + readOne);

            //인덱스 j의 값을 읽음
            readOne = scoreString.charAt(j);


            //char "숫자"를 int 형으로 변환
            int charToInt = readOne - '0';
            //System.out.println("charToInt: " + charToInt);

            scoreInt += charToInt;
            //TODO : 10인경우

            System.out.println("첫 번째 점수: " + scoreInt);

            if (readOne == 'S' || readOne == 'D' || readOne == 'T')

            // SDT 중에 하나만 받아서 연산처리
            switch(bonus) { // 읽는건 scoreString, 계산하는 건 scoreInt
                case S:
                    System.out.println("S 만남");
                    scoreInt = scoreInt ^ 1;
                break;
                case D:
                    System.out.println("D 만남");
                    scoreInt = scoreInt ^ 2;
                break;
                case T:
                    System.out.println("T 만남");
                    scoreInt = scoreInt ^ 3;
                break;

            }

            // 1~10 정수 하나 받고

            //한 글자씩 읽는거 필요

            // * || # 있는지 확인한 후 있으면 처리
            /*if (scoreString.equals("*") ) {
                scoreInt *= 2;
                //TODO : 1회차가 아닌 경우 바로 직전 점수도 *2 해야 함
            } else if (scoreString.equals("#")) {
                scoreInt *= -1;
            }
            System.out.println("scoreInt: " + scoreInt + "+");
            */
        }

        //출력
//        System.out.println(one);
//        System.out.println(two);
//        System.out.println(three);
//        System.out.println(four);
//        System.out.println(five);
//        System.out.println(six);
//        System.out.println(seven);

    }
}
