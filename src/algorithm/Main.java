package algorithm;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------Board []----------");
        Board board = new Board(10, 10);
        board.printBoard();

        System.out.println("----------Move Test----------");
        board.moveTest(5,5);
    }
}