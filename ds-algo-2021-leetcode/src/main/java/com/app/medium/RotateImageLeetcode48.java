package com.app.medium;

import java.util.Arrays;

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

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private static void print(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        rotate(matrix);

        print(matrix);
    }
}
