package kakao.p1;

public class P_01_06_re {
    public static void main(String[] args) {
        //입력
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        //처리
        int[][] mergedArr = new int[n][n]; //arr1과 arr2를 합친 2차원 배열 생성

        for (int col = 0; col < n; col++) {
            int result = arr1[col] | arr2[col]; //이진연산으로 둘 다 0인 경우만 추출

            for (int row = 0; row < n; row++) {
                mergedArr[col][row] = result & 1;
                result = result >> 1;
            }
        }

        //출력
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mergedArr[i][j]==1 ? "#" : " ");
            }
            System.out.println();
        }
    }
}
