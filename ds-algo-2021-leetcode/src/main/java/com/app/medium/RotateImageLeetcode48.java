package com.app.medium;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class RotateImageLeetcode48 {
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        int end = n - 1;
        while(start < end) {
            int[] tmp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = tmp;
            start++;
            end--;
        }

        int row = 0;
        while(row < n) {
            int col = row + 1;
            while(col < n) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
                col++;
            }
            row++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
