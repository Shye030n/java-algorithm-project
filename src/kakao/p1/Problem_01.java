package kakao.p1;

public class Problem_01 {
    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        for (int j = 0; j < n; j++) {
            int target = 1; //이진수의 가장 오른쪽 비트(첫번째 비트)
            String chg = ""; //결과를 저장할 공간
            int arr = arr1[j] | arr2[j]; // | 는, 두 값이 0일 때만 Arr에 반환
            for(int i = 0; i < n ; i++) {
                chg = ((arr & target) > 0 ? "#" : " ") + chg;
                target = target << 1;
            }
            System.out.println(chg);
        }
    }
}
