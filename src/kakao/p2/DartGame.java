package kakao.p2;

import java.util.Scanner;
/*
* Scanner 클래스를 가져온다.
* 키보드 입력을 받기 위해 필요한 도구
* */

public class DartGame { //DartGame 이라는 설계도(클래스)를 만들어서 사용하겠다.

    public static void main(String[] args) { //프로그램을 실행하면 가장 먼저 실행되는 곳. 즉 여기서부터 실행해라.

        Scanner sc = new Scanner(System.in); //키보드로 입력 받을 Scanner 객체를 생성한다. System.in은 키보드, sc는 키보드를 읽는 도구

        System.out.print("다트 결과 문자열 입력: "); //사용자에게 입력하라고 안내 문구 출력
        String dartResult = sc.nextLine(); //사용자가 입력한 한 줄을 문자열로 입력받아, dartResult에 저장

        int result = solution(dartResult); //입력받은 문자열을 solution(점수계산)함수에 넘겨 반환된 값을 result에 저장

        System.out.println("최종 점수: " + result); //계산된 점수를 화면에 출력한다.
    }

    public static int solution(String dartResult) { //String으로 입력받아, 점수를 계산하고 int를 리턴하는 함수

        int[] scores = new int[3];   // 3번 던지니까 3칸짜리 배열 생성
        int idx = -1;                // 몇 번째 판인지 표시하는 변수

        for (int i = 0; i < dartResult.length(); i++) { //문자열을 앞에서부터 한 글자씩 읽는다.
            char c = dartResult.charAt(i); //한 글자 읽어서 char형 변수 c에 저장

            System.out.println("현재 문자: " + c); //현재 처리중인 문자를 콘솔로 확인

            //숫자 처리
            if (c >= '0' && c <= '9') { //c가 숫자이면
                idx++; //***+1해서 다음 라운드로

                // 10 처리
                if (c == '1' && i + 1 < dartResult.length()
                        && dartResult.charAt(i + 1) == '0') {  //현재 숫자가 1이고 다음에 0이 오는 경우, 즉 10이면
                    scores[idx] = 10; //현재 라운드 점수를 10으로 저장
                    i++; //***이미 0까지 처리했으니 배열의 한 칸 건너뜀 => 0은 무시
                } else {
                    scores[idx] = c - '0'; //한자리 숫자 처리
                }

                System.out.println("점수 입력 → scores[" + idx + "] = " + scores[idx]); //어느 칸에 어떤 점수 들어갔는지 출력
            }

            // 보너스 처리
            /*
            * ### Math.pow(a,b); 는 a의 b제곱을 반환한다.
            * ### Math.pow(,) 의 결과는 double이기 때문에, 강제 형변환 (int)을 해줘야 한다.
            * ### 연산대상이 c가 아니라, int타입의 scores[idx]이라서
            * ### c는 스위치 역할
            * */
            else if (c == 'S') {
                scores[idx] = (int) Math.pow(scores[idx], 1);
            } else if (c == 'D') {
                scores[idx] = (int) Math.pow(scores[idx], 2);
            } else if (c == 'T') {
                scores[idx] = (int) Math.pow(scores[idx], 3);
            }

            // 옵션 처리
            else if (c == '*') {
                scores[idx] *= 2;
                if (idx > 0) {
                    scores[idx - 1] *= 2;
                }
            } else if (c == '#') {
                scores[idx] *= -1;
            }

            // 중간 상태 출력 (디버깅용)
            System.out.print("현재 scores 상태: ");
            for (int s : scores) {
                System.out.print(s + " ");
            }
            System.out.println("\n----------------------");
        }

        //최종 점수
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }

        return sum;
    }
}
