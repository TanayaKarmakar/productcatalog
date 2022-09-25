package com.app.medium;

/**
 * @author t0k02w6 on 25/09/22
 * @project ds-algo-2021-leetcode
 */
public class SetMatrixZeroesLeetcode73 {
    private static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                col = true;
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                row = true;
                break;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < n; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i < m;i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(row) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(col) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
