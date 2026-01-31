package kakao.p1;

public class P_01_04_정공법 {
    //입력
    int n;
    int[] arr1;
    int[] arr2;

    //2차원 배열 저장소
    //int[][] binaryArr;

    P_01_04_정공법(int n, int[] arr1, int[] arr2) {
        this.n = n;
        this.arr1 = arr1;
        this.arr2 = arr2;
        //배열 두개의 2진수를 비교한 값이 2진수로 출력됨
        // 그 출력된 2진수를 다시 10진수로 변환하여 출력됨
        //this.binaryArr = new int[n][n];
    }

    void compare() {
        System.out.println("---[ 최종 값 ]---");
        for(int c = 0; c < n; c++) {
            //System.out.println("---[합친 배열 출력]---");

            //두 배열을 합친 후 10진수로 출력
            int merged = arr1[c] | arr2[c];
            //System.out.println("ㅁ10진수: " + merged);

            //비교한 걸 다시 이진수로 변환 //했는데, String 타입은 >>(시프트연산) 불가여서 필요 없음.
            //String binary = Integer.toBinaryString(merged);
            //System.out.println("ㅁ2진수: " + binary);

            //2진수로 변환한 것을, 2차원 배열에 저장하지 않고 한 비트씩 옮겨가며 1과 비교
            for(int r = 0; r < n; r++) {
                //int zero = 1; //기준점
                int result = (merged >> (n - 1 - r)) & 1;
                System.out.print( result == 1 ? "#" : " ");

            }
            //System.out.println("0이면 공백, 1이면 # 출력");
            System.out.println();

        }
    }


    public static void main(String[] args) {
        P_01_04_정공법 p = new P_01_04_정공법(
                5,
                new int[] {9, 20, 28, 18, 11},
                new int[] {30, 1, 21, 17, 28}
        );
        p.compare();

    }
}
