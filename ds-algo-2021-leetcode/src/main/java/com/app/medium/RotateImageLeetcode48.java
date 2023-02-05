package com.app.medium;

/**
 * @author t0k02w6 on 27/01/23
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

    int row = 0;
    int col = 0;
    while(row < n) {
      for(int j = col; j < n; j++) {
        int tmp = matrix[row][j];
        matrix[row][j] = matrix[j][row];
        matrix[j][row] = tmp;
      }
      row++;
      col++;
    }
  }

  public static void main(String[] args) {

  }
}
