package com.app.hard;

public class SolveSudokuLeetcode37 {
    private static final int GRID_SIZE = 9;

    private static void solveSudoku(char[][] board) {
        boolean isPossible = solveSudokuRec(board);
        if(isPossible) {
            printSolution(board);
        }
    }

    private static void printSolution(char[][] board) {
        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveSudokuRec(char[][] board) {
        int row = -1;
        int col = -1;
        boolean isFilled = true;
        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                if(board[i][j] == '.') {
                    isFilled = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(!isFilled)
                break;
        }

        if(isFilled)
            return true;

        for(int num = 1; num <= GRID_SIZE; num++) {
            if(isSafe(board, row, col, num)) {
                board[row][col] = (char)(num + '0');
                if(solveSudokuRec(board))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, int num) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[row][i] - '0' == num)
                return false;
        }

        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[i][col] - '0' == num)
                return false;
        }

        int sqrt = (int)Math.sqrt(GRID_SIZE);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;
        for(int r = startRow; r < (startRow + sqrt); r++) {
            for(int c = startCol; c < (startCol + sqrt); c++) {
                if(board[r][c] - '0' == num)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
