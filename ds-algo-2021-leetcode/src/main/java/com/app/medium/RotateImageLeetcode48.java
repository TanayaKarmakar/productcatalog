package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */
public class RotateImageLeetcode48 {
  private static void rotate(int[][] matrix) {
    int m = matrix.length;
    int start = 0;
    int end = m - 1;


    while(start < end) {
      int[] tmp = matrix[start];
      matrix[start] = matrix[end];
      matrix[end] = tmp;
      start++;
      end--;
    }

    int i = 0;
    while(i < m) {
      int j = i + 1;
      while(j < m) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
        j++;
      }
      i++;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    rotate(matrix);

    for(int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }
}
