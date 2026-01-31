package kakao.p1;

public class P_01_2 {

    int n;
    int[] arr1;
    int[] arr2;

    // 변환된 배열을 2차원 배열로 바꿈
    String[][] arr1_binary;
    String[][] arr2_binary;


    P_01_2 (int n, int[] arr1, int[] arr2 ) {
     this.n = n;
     this.arr1 = arr1;
     this.arr2 = arr2;
    }

    /*
    * 주어진 배열을 2진수로 변환하며 배열로 저장
    * 변환된 배열을 비교하는 메서드 필요
    * 2차원 배열을 순회하면서 비교해야해.
    * */

    void intToBinaryArr(int[][] arr1_binary,int[][] arr2_binary) { //
        for(int c = 0; c < n; c++) {
            for(int r = 0; r < n; r++) {

                String compare= Integer.toBinaryString(arr1_binary[c][r] | arr2_binary[c][r]);
                System.out.println("컴페어값: " + compare);

                //System.out.println("arr1_binary: " + arr1_binary);
                //System.out.print(arr1_binary.equals("0") ? " " : "#"); //여기서 compare은 1인데, 값은 11111이라 다 false로 반환됨. => 그럼 이차원 배열로 비교하면 되는거잖아.
            }
            System.out.println();

        }
    }
    //
    //변환된 배열들의 값을 비교하는 메서드
    void compare(int[][] arr1_binary, int[][] arr2_binary) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                String compare = Integer.toBinaryString(arr1_binary[i][j] | arr2_binary[i][j]);
                System.out.print(compare.equals("0") ? " " : "#");
                System.out.println(arr1_binary[i][j] + " | " + arr2_binary[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        P_01_2 p1 = new P_01_2(
                5,
                new int[] {9, 20, 28, 18, 11},
                new int[] {30, 1, 21, 17, 28}
        );

        //p1.intToBinaryArr(p1.arr1_binary, p1.arr2_binary);

    }
}
