package kakao.p1;

/*
* 문제 이해 )
* 배열의 크기와
* 두 개의 정수 배열을 입력하면,
* 각 정수를 이진수로 변환하고,
* 변환한 이진수를 열로 하나씩 추가해서 2차원 정사각형 배열을 만든다.
* 그럼 두 개의 정사각형 배열이 만들어지는데, 이를 둘 중 하나라도 1이 있는 경우는 벽이다.
* 따라서 배열의 원소를 1의 이진수와 비교하여 둘 다 1인 경우를 뽑아내고, 비교할 배열을 한 비트 옮겨 이를 반복하여
* 0인 경우와 1인 경우에 따라 각 다르게 출력한다.
* 만들고,
*/
public class P_01_06_re2 {
    public static void main(String[] args) {
        //입력
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        //처리
        int[][] mergedArr = new int[n][n];

        for (int col = 0; col < n; col++) {
            int result = arr1[col] | arr2[col]; //둘 다 0인 경우 추출

            for (int row = 0; row < n; row++) {
                mergedArr[col][row] = result & 1;
                //&는, 비교하는 두 값을 이진수로 바꿔서 각 자리, 즉 각 비트마다 비교하여 둘 다 1인 경우에만 1을 반환한다.
                result = result >> 1; //result를 오른쪽으로 1bit 이동
            }
        }

        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mergedArr[i][j] == 1 ? "#" : " ");
        }
        System.out.println();
    }
}
