package kakao.p2;

public class p02_4 {
    /*
    - 문자열 처리를 묻는 문제다
    - 앞에서부터 한 글자씩 잘라서 처리한다 ◀여기를 charAt(i)
        유의할 점) 10점인 경우
    - 정규식으로 토큰화 해라.
    - 의미 분석은
        S,D,T는 각 일제곱,제곱,세제곱으로
        *은 x2 , # x(-1)
    */

        /*
        * 문자열 one을 토큰 세개로 나눈다.
        * 세 개로 나는 문자열을 한 글자씩 읽어서/잘라서 처리한다.
        * 세 판 => for문 3번 반복 => 토큰 하나를
        * */
    public static void main(String[] args) {
        //입력
        String one = "1S2D*3T"; //37
        //String two = "1D2S#10S"; //9
        //String three = "1D2S0T"; //3


        //처리
        // 구분자
        String regex = "^([1-9]|10)[SDT][*#]?$";

        //구분자를 기준으로 토큰처리한 애들 저장소
        String[] tokens;
        tokens = one.split(regex);
        System.out.println(tokens[0]);
        System.out.println(tokens[1]); //안나뉘었으니까

        //1.패턴 객체에 내가 만든 구분자를 저장하는 패턴 객체를 생성
        //Pattern pattern = Pattern.compile(regex);
        //2. 패턴 객체를 matcher 메서드로 문자열을 검사하고 필터링된 결과를 매처 객체로 변환
        //Matcher matcher = pattern.matcher(one);
        //System.out.println(matcher);

        //3. 정규식으로 필터링된 결과를 담은 matcher 메서드로 결과 출력
        //System.out.println(matcher.find()); //매칭된 결과가 있는가
        //System.out.println(matcher.group()); //매칭된 부분은 뭔가



        //문자열 one을 토큰 세 개로 나누는 로직
        //String[] tokens = pattern.split(one, 3);
        //System.out.println(tokens[0]);


        /*System.out.println(tokens.length);
        System.out.println(tokens[0]);
        System.out.println(tokens[1]);
        System.out.println(tokens[2]);*/

        /*
        for(int i = 0; i < 3 ; i++) { //3은 토큰 개수
            readOne = token.charAt(i);
            switch(token) {
                case "[정수형]":
                    score += Integer.parseInt(readOne);
                    break;

                case "[SDT]" :
                    if(readOne.equals("S")) {
                        System.out.println("S 만남");
                    }else if(readOne.equals("D")) {
                        System.out.println("D 만남");
                    } else {
                        System.out.println("T 만남");
                }
                    break;

                case "[#*]" :
                    break;
            }

            //token.charAt(i);
            //여기서는 계산 로직만

        }
        */


        //출력


    }
}
