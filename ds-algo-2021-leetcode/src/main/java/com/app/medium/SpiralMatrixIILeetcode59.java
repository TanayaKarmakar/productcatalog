package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 13/04/22
 * @project ds-algo-2021
 */
public class SpiralMatrixIILeetcode59 {
    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];


        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int value = 1;

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            for(int i = right; i >= left; i--) {
                matrix[bottom][i] = value++;
            }
            bottom--;

            for(int i = bottom; i >= top; i--) {
                matrix[i][left] = value++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
