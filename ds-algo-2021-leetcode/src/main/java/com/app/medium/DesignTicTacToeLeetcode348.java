package com.app.medium;

/**
 * @author t0k02w6 on 09/04/22
 * @project ds-algo-2021
 */
class TicTacToe {
    char[][] board;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        board = new char[n][n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player == 1 ? 'X': 'O';
        boolean hasWon = hasWonGame(row, col, 'X');
        if(hasWon)
            return player;
        return 0;
    }

    private boolean hasWonGame(int row, int col, char sign) {
        boolean hasWon = true;

        for(int j = 0; j < n; j++) {
            if(board[row][j] != sign) {
                hasWon = false;
                break;
            }

        }
        if(hasWon)
            return true;

        hasWon = true;
        for(int i = 0; i < n; i++) {
            if (board[i][col] != sign) {
                hasWon = false;
                break;
            }
        }
        if(hasWon)
            return true;

        hasWon = true;
        for(int i = 0, j = 0; i < n && j < n; i++, j++) {
            if (board[i][j] != sign) {
                hasWon = false;
                break;
            }
        }
        if(hasWon)
            return true;

        int i = 0;
        int j = n - 1;
        hasWon = true;
        while(i < n && j >= 0) {
            if(board[i][j] != sign) {
                hasWon = false;
                break;
            }
            i++;
            j--;
        }
        return hasWon;
    }
}


public class DesignTicTacToeLeetcode348 {
    public static void main(String[] args) {

    }
}
