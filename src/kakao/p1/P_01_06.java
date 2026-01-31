package kakao.p1;

public class P_01_06 {
    public static void main(String[] args) {
        //입력
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        //처리
        int[][] mergedArr = new int[n][n]; //arr1과 arr2를 합친거 저장소 생성

        for (int col = 0; col < n; col++) {
            int result = arr1[col] | arr2[col]; //이진법으로 둘 다 0인 경우만 저장

            for (int row = 0; row < n; row++) {
                mergedArr[col][row] = result & 1; //합친 배열 값의 첫비트와 2진수 1과 비교하여 1인 경우만 저장
                result >>= 1; // 왼쪽에 0을 붙여 result를 오른쪽으로 한 비트 이동
            }
        }

        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mergedArr[i][j]==1 ? "#" : " ");
            }
            System.out.println();
        }
    }
}
