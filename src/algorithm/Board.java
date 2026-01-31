package algorithm;

public class Board {

    //게임판
    int[][] board;
    //상하좌우 이동
    int[] dr = {-1, 1, 0, 0}; //행 변화량
    int[] dc = {0, 0, -1, 1}; //열 변화량

    public Board(int rows, int cols) {
        board = new int[rows][cols];
    }

    //이동 범위 제한
    public boolean inRange(int r, int c) { //(현재 열, 현재 행)
        return r >= 0 && r < board.length
                && c >= 0 && c < board[0].length;
    }

    //이동
    public void moveTest(int r, int c) {
        for (int d = 0; d < dr.length ; d++) { //d는 방향
            int nc = c + dc[d]; //이동 후 행
            int nr = r + dr[d]; //이동 후 열
            if (!inRange(nc, nr)) continue;
            System.out.println("(" + nr + ", " + nc + ")");

        }
    }

    //보드 출력
    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
                    board[i][j] = 1;
                    System.out.print(board[i][j] + " ");
                } else if (i%2 == 0) {
                    board[i][j] = 0;
                    System.out.print(board[i][j] + " ");
                } else {
                    board[i][j] = 3;
                    System.out.print(board[i][j] + " ");

                }
            }
            System.out.println();
        }

    }

}
