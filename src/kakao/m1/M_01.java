package kakao.m1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 숫자 판독기 */
public class M_01 {
    /*
    // 로직 흐름 큰 틀
    * 가로선, 세로선, 대각선, 접점을 정의
    * 선과 점이 각 n개인 경우 -> 숫자 (예: 가로선이 2개, 세로선 0개, 대각선 1개, 접점이 2개인 경우는 2다.)
    * 출력
    * 이진연산으로 비교. 쉬프트연산으로 비교
    * 문자열 입력 -> 2차원 배열 변환
    */

    /* 입력받은 문자열을 2차원 배열로 변환하는 메서드 */

    /* 선과 점의 개수를 저장할 변수*/
    int horizontalLine; //가로선
    int verticalLine; //세로선
    int diagonalLine; //대각선
    int intersectionPoint; //접점

    public M_01(int horizontalLine, int verticalLine, int diagonalLine, int intersectionPoint) {
        this.horizontalLine = horizontalLine;
        this.verticalLine = verticalLine;
        this.diagonalLine = diagonalLine;
        this.intersectionPoint = intersectionPoint;
    }

    /* 선과 점을 정의하는 메서드 */
    public static void isHorizontal() {

    }
    public static void isVertical() {

    }
    public static void isDiagonal() {

    }
    public static void isIntersection() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine(); //문자열을 입력받는다.
        char[] chars = line.toCharArray(); //입력받은 문자열의 한 글자씩 char[]에 저장한다

        /*TODO : 하단 로직, 메인메서드에서 작성하는 게 아니라, M_01 객체를 생성해서 메서드로 불러오도록 */
        int[] arr = new int[chars.length]; //정수형으로 변환한 정수 저장소
        for(int i = 0; i < chars.length; i++) { //원소 개수만큼 반복하여
            arr[i] = chars[i] - '0'; //char -> int
        }
    }
}
