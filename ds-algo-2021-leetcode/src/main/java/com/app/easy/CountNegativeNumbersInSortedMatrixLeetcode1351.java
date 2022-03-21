package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class CountNegativeNumbersInSortedMatrixLeetcode1351 {
    private static int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            if(grid[i][0] < 0) {
                count += n;
            } else {
                int j = n - 1;
                while(j >= 0 && grid[i][j] < 0) {
                    j--;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
