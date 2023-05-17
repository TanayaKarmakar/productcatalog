package com.app.easy;

/**
 * @author t0k02w6 on 14/05/23
 * @project ds-algo-2021-leetcode
 */
public class CountNegativeNumbersInSortedMatrixLeetcode1351 {
  private static int countNegatives(int[][] grid) {
    int count = 0;
    int m = grid.length;
    int n = grid[0].length;

    for(int i = 0; i < m; i++) {
      int firstIndexOfNegative = getFirstIndexOfNegative(grid[i], n);
      if(firstIndexOfNegative != -1)
        count += (n - firstIndexOfNegative);
    }

    return count;
  }

  private static int getFirstIndexOfNegative(int[] nums, int n) {
    int start = 0;
    int end = (n - 1);

    while(start <= end) {
      int mid = (start + end) >> 1;
      if(nums[mid] < 0 && (mid == 0 || nums[mid - 1] > 0))
        return mid;
      else if(nums[mid] > 0) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

    int ans = countNegatives(grid);

    System.out.println(ans);
  }
}
