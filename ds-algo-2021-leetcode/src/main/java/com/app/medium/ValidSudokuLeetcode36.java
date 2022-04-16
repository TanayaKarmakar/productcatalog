package com.app.medium;

/**
 * @author t0k02w6 on 03/04/22
 * @project ds-algo-2021
 */
public class ValidSudokuLeetcode36 {
    private static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!isValid(board, board[i][j], i, j))
                        return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, char c, int row, int col) {
        //search column wise
        for(int i = 0; i < 9; i++) {
            if(col != i && board[row][i] == c)
                return false;
        }

        //search row wise
        for(int i = 0; i < 9; i++) {
            if(row != i && board[i][col] == c)
                return false;
        }

        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for(int i = startRow; i < (startRow + 3); i++) {
            for(int j = startCol; j < (startCol + 3); j++) {
                if(board[i][j] == c && (i != row || j != col))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
