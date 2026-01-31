package kakao.p1;

public class P_01 {

    //TODO => 나중에 BufferedReader로 입력 받는거

    //입력
    int n;
    int[] arr1;
    int[] arr2;

    //10->2진수, 변환 결과를 저장할 메서드명
    String binaryArr;

    //2차원 배열 저장소
    char[][] matrixArr1;
    char[][] matrixArr2;

    P_01(int n, int[] arr1, int[] arr2) {
        this.n = n;
        this.arr1 = arr1;
        this.arr2 = arr2;

        this.matrixArr1 = intToBinaryArr(arr1);
        this.matrixArr2 = intToBinaryArr(arr2);
    }

    //10진수 -> 2진수 및 5칸 초기화 메서드
    char[][] intToBinaryArr(int[] arr) { //배열의{ 원소를 (10진수->5칸 2진수)로 변환한 걸 이차원 배열로 만드는 메서드

        int n = arr.length;
        //2차원배열 저장소
        char[][] intToBinaryArr = new char[n][n];

        for(int i = 0; i < n; i++) {
            //10진수 -> 2진수 변환
            binaryArr = Integer.toBinaryString(arr[i]);

            // !) 0으로 시작하는 경우, 4글자로 출력됨. -> (5-글자수)만큼 앞에 0을 붙여 초기화
            if(binaryArr.length() < 5) {
                binaryArr = "00000".substring(binaryArr.length()) + binaryArr;
            }

            //2진수로 변환된 문자열을 한 글자씩 저장
            intToBinaryArr[i] = binaryArr.toCharArray();

        }
        return intToBinaryArr;
    };

    public static void main(String[] args) {

        //처리
        /* 배열을 순회하여 10진수를 2진수로 변환하고, 5글자 미만인 경우 앞에 0을 붙여 5글자로 통일하고_intToBinaryArr()
        * 변환된 2진수의 각 글자로 새로운 2차원 배열을 생성
        * 배열의[세][가] (같은 영역?)의 숫자를 비교하여, | (OR연산자) 로 둘 다 0인 경우만 반환
        * 삼항연산자로 ("0인 경우" ? " " : "#") 이렇게
        * 또 반복문으로 출력한다.
        * */

        P_01 p1 = new P_01(
                5,
                new int[]{9, 20, 28, 18, 11},
                new int[]{30, 1, 21, 17, 28}
        );


        for(int r = 0; r < p1.n; r++) {

            String result = ""; //결과 저장할 공간

            for (int c = 0; c < p1.n; c++) {
                //TODO => 비트연산을 사용하려면 정수여야하는데, 나는 String으로 받아버림
                int zero = p1.matrixArr1[r][c] | p1.matrixArr2[r][c];
                result += (zero == 0) ? " " : "#";

                //이차원배열 1,2의 인덱스가 모두 0인 경우를 &&로 처리
//                result +=
//                        (p1.matirxArr1[r][c] == '0' && p1.matirxArr2[r][c]) == "0" ? " " : "#";
//
//            }
            }
                System.out.println(result);
        }


        System.out.println("-----p1.matrixArr1-----");
        for (char[] mA1 : p1.matrixArr1) {
            System.out.println(mA1);
        }
        System.out.println();
        System.out.println("-----p1.matrixArr2-----");
        for (char[] mA2 : p1.matrixArr2) {

            System.out.println(mA2);
        }

    }
}




