package com.app.medium;

/**
 * @author t0k02w6 on 01/08/21
 * @project ds-algo-2021
 */
public class ValidSudokuLeetcode36 {
    private static final int BOARD_SIZE = 9;
    private static final int SQRT = 3;

    private static boolean isValid(char[][] board, int i, int j) {
        char num = board[i][j];
        for(int c = 0; c < BOARD_SIZE; c++) {
            if(j != c && board[i][c] == num)
                return false;
        }

        for(int r = 0; r < BOARD_SIZE; r++) {
            if(i != r && board[r][j] == num)
                return false;
        }

        int startRow = i - (i % SQRT);
        int startCol = j - (j % SQRT);

        for(int r = startRow; r < startRow + SQRT; r++) {
            for(int c = startCol; c < startCol + SQRT; c++) {
                if((i != r || j != c) && board[r][c] == num)
                    return false;
            }
        }
        return true;
    }

    private static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                if(Character.isDigit(board[i][j]) && !isValid(board, i, j))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        boolean ans = isValidSudoku(board);
        System.out.println(ans);
    }
}
