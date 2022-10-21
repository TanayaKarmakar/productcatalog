package com.app.medium;

/**
 * @author t0k02w6 on 29/09/22
 * @project ds-algo-2021-leetcode
 */
public class BattleShipOnBoardLeetcode419 {
    private static int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    if((i > 0 && board[i - 1][j] == 'X')
                        || (j > 0 && board[i][j - 1] == 'X'))
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
