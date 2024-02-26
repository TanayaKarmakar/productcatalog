package com.app.medium;

public class ValidSudokuLeetcode36 {
    private static boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    char ch = board[i][j];
                    board[i][j] = '.';
                    if(!isValid(board, i, j, n, ch)) {
                        return false;
                    }
                    board[i][j] = ch;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int i, int j, int n, char ch) {
        // check for current row
        for(int col = 0; col < n; col++) {
            if(board[i][col] == ch)
                return false;
        }

        // check for current row
        for(int row = 0; row < n; row++) {
            if(board[row][j] == ch)
                return false;
        }

        int sqrt = (int)Math.sqrt(n);
        int startRow = i - (i % sqrt);
        int startCol = j - (j % sqrt);

        for(int i1= startRow; i1 < (startRow + sqrt); i1++) {
            for(int j1 = startCol; j1 < (startCol + sqrt); j1++) {
                if(board[i1][j1] == ch)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
