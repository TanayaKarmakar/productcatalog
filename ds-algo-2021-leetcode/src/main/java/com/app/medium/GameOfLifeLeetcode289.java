package com.app.medium;

/**
 * @author t0k02w6 on 09/04/22
 * @project ds-algo-2021
 */
public class GameOfLifeLeetcode289 {
    private static int[][] directions = {{-1, 0},{1, 0},{0, -1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

    private static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] nextState = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveCellCount = 0;
                for(int k = 0; k < directions.length; k++) {
                    int newRow = i + directions[k][0];
                    int newCol = j + directions[k][1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || board[newRow][newCol] == 0)
                        continue;
                    liveCellCount++;
                }

                if(board[i][j] == 1) {
                    if(liveCellCount == 2 || liveCellCount == 3)
                        nextState[i][j] = 1;
                } else {
                    if (liveCellCount == 3)
                        nextState[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = nextState[i][j];
            }
        }

    }

    public static void main(String[] args) {

    }
}
