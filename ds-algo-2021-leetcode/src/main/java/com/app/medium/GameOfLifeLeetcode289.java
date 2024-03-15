package com.app.medium;

public class GameOfLifeLeetcode289 {
    private static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{1,-1},{-1,-1},{1,1}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveCellCount = 0;
                for(int k = 0; k < dirs.length; k++) {
                    int newRow = i + dirs[k][0];
                    int newCol = j + dirs[k][1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                        continue;
                    if(Math.abs(board[newRow][newCol]) == 1)
                        liveCellCount++;
                }

                if(board[i][j] == 0) {
                    if(liveCellCount == 3)
                        board[i][j] = 2;
                }
                if(board[i][j] == 1) {
                    if(liveCellCount < 2 || liveCellCount > 3)
                        board[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] < 0)
                    board[i][j] = 0;
                else if(board[i][j] > 1)
                    board[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {

    }
}
