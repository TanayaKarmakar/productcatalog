package com.app.medium;

import java.util.Arrays;

public class SetMatrixZeroesLeetcode73 {
    private static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row = false;
        boolean col = false;

        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                row = true;
                break;
            }
        }

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                col = true;
                break;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
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
                for(int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(row) {
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if(col) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        setZeroes(matrix);

        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("**********************************");
        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setZeroes(matrix);

        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
