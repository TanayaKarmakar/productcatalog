package com.app.medium;

/**
 * @author t0k02w6 on 14/05/23
 * @project ds-algo-2021-leetcode
 */
public class SearchIn2DMatrixLeetcode74 {
  private static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int start = 0;
    int end = (m * n) - 1;

    while(start <= end) {
      int mid = (start + end) >> 1;
      int row = (mid / n);
      int col = (mid % n);
      if(matrix[row][col] == target) {
        return true;
      } else if(matrix[row][col] > target)
        end = mid - 1;
      else
        start = mid + 1;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

    boolean ans = searchMatrix(matrix, 3);

    System.out.println(ans);

    ans = searchMatrix(matrix, 13);

    System.out.println(ans);
  }
}
