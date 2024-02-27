package com.app.medium.design;


class TicTacToe {
    char[][] board;
    int size;

    public TicTacToe(int n) {
        this.board = new char[n][n];
        this.size =n;
    }

    public int move(int row, int col, int player) {
        char ch = player == 1 ? 'X': '0';
        board[row][col] = ch;
        boolean hasWon = hasWon(ch, row, col);
        if(hasWon)
            return player;
        return 0;
    }

    private boolean hasWon(char ch, int row, int col) {
        boolean hasWon = true;
        for(int c = 0; c < size; c++) {
            if(board[row][c] != ch) {
                hasWon = false;
                break;
            }
        }

        if(hasWon)
            return true;

        hasWon = true;
        for(int r = 0; r < size; r++) {
            if(board[r][col] != ch) {
                hasWon = false;
                break;
            }
        }

        if(hasWon)
            return true;


        hasWon = true;
        int i =0;
        while(i < size) {
            if(board[i][i] != ch) {
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
            if(board[i][j] != ch) {
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
