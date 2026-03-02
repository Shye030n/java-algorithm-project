package practice;

public class BinaryScale {
    public static void main(String[] args) {

    int decimal = 10;
    // *** 10진수 -> 2진수_toBinaryString(int i)
    String binary = Integer.toBinaryString(decimal);
    //10진수 -> 8진수_toOctalString(int i)
    String octal = Integer.toOctalString(decimal);
    //10진수 -> 16진수_toHexString(int i)
    String hexDecimal = Integer.toHexString(decimal);

    //parseInt(String s)
    //parseInt(String s, int radix)
    // *** 2진수 -> 10진수
    int binaryToDecimal = Integer.parseInt("1010", 2);
    //8진수 -> 10진수
    int octalToDecimal = Integer.parseInt("14", 8);
    //16진수 -> 10진수
    int hexToDecimal = Integer.parseInt("A", 16);

     System.out.println("10진수: " + decimal);
     System.out.println("2진수: " + binary);
     System.out.println("8진수: " + octal);
     System.out.println("16진수: " + hexDecimal);
     System.out.println("2->10진수: " + binaryToDecimal);
     System.out.println("8->10진수: " + octalToDecimal);
     System.out.println("16->10진수: " + hexToDecimal);
    }
}

