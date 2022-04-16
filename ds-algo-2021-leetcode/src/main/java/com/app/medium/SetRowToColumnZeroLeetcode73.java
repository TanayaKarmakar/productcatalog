package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 14/04/22
 * @project ds-algo-2021
 */
public class SetRowToColumnZeroLeetcode73 {
    private static void setZeroes(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];

            for(int i = 0; i < matrix[0].length; i++) {
                if(matrix[r][i] == 0)
                    continue;
                matrix[r][i] = 0;
            }

            for(int i = 0; i < matrix.length; i++) {
                if(matrix[i][c] == 0)
                    continue;
                matrix[i][c] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
