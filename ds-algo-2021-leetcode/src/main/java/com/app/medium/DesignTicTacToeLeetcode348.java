package com.app.medium;

/**
 * @author t0k02w6 on 29/09/22
 * @project ds-algo-2021-leetcode
 */

class TicTacToe {
    char[][] board;
    int size;

    public TicTacToe(int n) {
        this.size = n;
        board = new char[n][n];
    }

    public int move(int row, int col, int player) {
        boolean hasWon = hasWon(row, col, player);
        if(hasWon)
            return player;
        return 0;
    }

    private boolean hasWon(int row, int col, int player) {
        char sign = player == 1 ? 'X':'0';
        this.board[row][col] = sign;
        boolean hasWon = true;
        for(int j = 0; j < size; j++) {
            if(board[row][j] != sign) {
                hasWon = false;
                break;
            }
        }

        if(hasWon)
            return true;

        hasWon = true;
        for(int i = 0; i < size; i++) {
            if(board[i][col] != sign) {
                hasWon = false;
                break;
            }
        }

        if(hasWon)
            return true;

        hasWon = true;
        int i = 0;
        while(i < size) {
            if(board[i][i] != sign) {
                hasWon = false;
                break;
            }
            i++;
        }

        if(hasWon)
            return true;

        hasWon = true;
        i = 0;
        int j = size - 1;
        while(i < size && j >= 0) {
            if(board[i][j] != sign) {
                hasWon = false;
                break;
            }
            i++;
            j--;
        }

        if(hasWon)
            return true;
        return false;

    }
}


public class DesignTicTacToeLeetcode348 {
    public static void main(String[] args) {

    }
}
