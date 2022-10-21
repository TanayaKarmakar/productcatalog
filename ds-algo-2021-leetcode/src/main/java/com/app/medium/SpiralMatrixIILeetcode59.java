package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class SpiralMatrixIILeetcode59 {
  private static int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int startRow = 0;
    int endRow = n - 1;
    int startCol = 0;
    int endCol = n - 1;

    int value = 1;
    while(startRow <= endRow && startCol <= endCol) {
      for(int j = startCol; j <= endCol; j++) {
        result[startRow][j] = value++;
      }
      startRow++;

      for(int j = startRow; j <= endRow; j++) {
        result[j][endCol] = value++;
      }
      endCol--;

      for(int j = endCol; j >= startCol; j--) {
        result[endRow][j] = value++;
      }
      endRow--;

      for(int j = endRow; j>= startRow; j--) {
        result[j][startCol] = value++;
      }
      startCol++;
    }
    return result;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] result = generateMatrix(n);

    for(int i = 0; i < n; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }
}
