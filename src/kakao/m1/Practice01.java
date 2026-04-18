package kakao.m1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice01 {
    /* 선과 점의 개수를 저장할 변수*/
    int horizontalLine; //가로선
    int verticalLine; //세로선
    int diagonalLine; //대각선
    int intersectionPoint; //접점


    int[][] matrixArr = new int[10][10]; //2차원 배열 저장소

    Practice01() {

    }


    /* 선 개수 확인 메서드 */
    public static void countLine1() {
        for(int col = 0; col < 10; col++) { //열
            //TODO : 행에서 1이 연속되면 세로선++;
            for(int row = 0; row < 10; row++) { //행
                //TODO : 열과 행이 동시에 증가할 때 1이 연속되면 대각선 ++; //좌하향 대각선

            }
        }
    }

    public static void countLine2() { //우상향 대각선
        for(int col = 10; col > 0; col--) {
            for(int row = 10; row > 0; row--) {
                //TODO : 열과 행이 동시에 감소할 때 1이 연속되면 대각선 ++;
            }
        }
    }

    public static void countLine3() {
        for (int row = 0; row < 10; row++) {
            //TODO : 열에서 1이 연속되면 가로선++;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Practice01 p  = new Practice01();

    }
}
