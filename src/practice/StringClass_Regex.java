package practice;

public class StringClass_Regex {
    public static void main(String[] args) {
        //matches
        String txt = "123456";
        boolean result1 = txt.matches("[0-9]+"); //숫자로만 이루어졌는지와 매치/비교
        System.out.println("result1 은 " + result1);

        //replaceAll(정규식과 일치하는 모든 값 치환)
        String txt2 = "sheyo_on*-?/";
        String result2 = txt2.replaceAll("[^a-z0-9]","0"); //소문자와 숫자로 이루어지지 않은 문자는 0으로 치환
        System.out.println("result2 은 " + result2);

        //split(정규표현식과 일치하는 값을 구분자로 설정)
        String txt3 = "s1he3yo_6on*-?/";
        String[] result3 = txt3.split("[0-9]+");;
        System.out.println("result3 은 " + result3[0]);
        System.out.println("result3 은 " + result3[1]);

    }
}
