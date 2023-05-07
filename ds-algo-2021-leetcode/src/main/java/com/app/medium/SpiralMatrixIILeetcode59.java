package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 26/04/23
 * @project ds-algo-2021-leetcode
 */
public class SpiralMatrixIILeetcode59 {
  private static int[][] generateMatrix(int n) {
    int value = 1;
    int[][] matrix = new int[n][n];

    int startRow = 0;
    int endRow = n - 1;
    int startCol = 0;
    int endCol = n - 1;

    while(startRow <= endRow && startCol <= endCol) {
      for(int j = startCol; j <= endCol; j++) {
        matrix[startRow][j] = value++;
      }

      startRow++;
      for(int j = startRow; j <= endRow; j++) {
        matrix[j][endCol] = value++;
      }
      endCol--;

      for(int j = endCol; j >= startCol; j--) {
        matrix[endRow][j] = value++;
      }
      endRow--;

      for(int j = endRow; j >= startRow; j--) {
        matrix[j][startCol] = value++;
      }
      startCol++;
    }

    return matrix;

  }

  public static void main(String[] args) {
    int[][] matrix = generateMatrix(3);
    for(int i = 0; i < 3; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }
}
