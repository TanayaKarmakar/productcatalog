package com.app.medium;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
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

        int i = 0;
        int j = 0;
        while(i < n && j < n) {
            for(int k = i; k < n; k++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = tmp;
            }
            i++;
            j++;
        }
    }

    public static void main(String[] args) {

    }
}
