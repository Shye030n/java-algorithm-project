package kakao.p1;

public class P_01_5 {
    public static void main(String[] args) {

        //입력
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        //처리
        //자바가 해주는 2진수 계산을 2차원 배열로 저장할 공간 생성
        int[][] binaryArr = new int[n][n];

        //두 배열을 합쳐서 하나라도 1인 경우 뽑아내기
        for(int row = 0; row < n; row++) {
            int result = arr1[row] | arr2[row]; //둘 다 0인 경우만 골라냄 => 길
            //System.out.println(result); // 숫자를 위 아래로 겹쳐놓고, 둘 다 0 인경우에만 0으로 한 10진수가 출력됨

            for(int col = 0; col < n; col++) {
                binaryArr[row][col] = result & 1 ; //첫 비트가 1인 경우만 남기고
                result >>= 1; //왼쪽에 0을 붙여 오른쪽으로 한 비트씩 이동
                //result = result >> 1;
            }
        }
        //출력
        for(int col = 0; col < n; col++) {
            for(int row = 0; row < n; row++) {
                System.out.print(binaryArr[row][col] == 1 ? "#" : " "); // ?) 왜 자꾸 1로 하지
            }
            System.out.println();
        }



    }
}
