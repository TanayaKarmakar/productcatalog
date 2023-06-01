package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class SpiralMatrixLeetcode54 {
  private static List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int top = 0;
    int bottom = m - 1;
    int left = 0;
    int right = n - 1;

    List<Integer> result = new ArrayList<>();

    while(top <= bottom && left <= right) {
      for(int j = left; j <= right; j++) {
        result.add(matrix[top][j]);
      }
      top++;

      for(int j = top; j <= bottom; j++) {
        result.add(matrix[j][right]);
      }

      right--;
      if(top <= bottom) {
        for(int j = right; j >= left; j--) {
          result.add(matrix[bottom][j]);
        }
        bottom--;
      }

      if(left <= right) {
        for(int j = bottom; j >= top; j--) {
          result.add(matrix[j][left]);
        }
        left++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

    List<Integer> result = spiralOrder(matrix);

    System.out.println(result);

    matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    result = spiralOrder(matrix);

    System.out.println(result);
  }
}
