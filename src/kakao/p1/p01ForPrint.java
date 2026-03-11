package kakao.p1;

public class p01ForPrint {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        int[][] mergedArr = new int[n][n];

        for (int col = 0; col < n; col++) {
            int result = arr1[col] | arr2[col];

            for (int row = 0; row < n; row++) {
                mergedArr[col][row] = result & 1;
                result >>= 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mergedArr[i][j]==1 ? "#" : " ");
            }
            System.out.println();
        }
    }
}
