package kakao.p1;

public class P_01_3 {

    int n;
    int[] arr1;
    int[] arr2;
    int[][] arr1_binary = new int[n][n];
    int[][] arr2_binary = new int[n][n];

    P_01_3(int n, int[] arr1, int[] arr2) {
        this.n = n;
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    void intToBinaryArr(int[][] arr1_binary, int[][] arr2_binary) {
     for(int c = 0; c < n; c++) {
         for(int r = 0; r < n; r++) {
             String result = Integer.toBinaryString(arr1[r] | arr2[r]);
             System.out.println("배열1 가로: " + arr1[r]);
             System.out.println("배열2 가로: " + arr2[r]);
         }
     }
    }

    public static void main(String[] args) {
        P_01_3 p = new P_01_3(
                5,
                new int[] {1, 2, 3, 4, 5},
                new int[] {10, 9, 8, 7, 6}
        );
        p.intToBinaryArr(p.arr1_binary, p.arr2_binary);

    }
}
