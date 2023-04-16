package com.app.medium;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class SearchInA2DMatrixIILeetcode240 {
  private static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int i = 0;
    int j = n - 1;

    while(i < m && j >= 0) {
      if(matrix[i][j] == target)
        return true;
      else if(matrix[i][j] > target)
        j--;
      else
        i++;
    }
    return false;
  }

  public static void main(String[] args) {

  }
}
