package com.app.medium;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class ContainerWithMostWaterLeetcode11 {
  private static int maxArea(int[] height) {
    int n = height.length;
    int left = 0;
    int right = n - 1;

    int maxArea = Integer.MIN_VALUE;
    while(left <= right) {
      int min = Integer.min(height[left], height[right]);
      maxArea = Integer.max(maxArea, min * (right - left));
      if(min == height[left])
        left++;
      else
        right--;
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int[] nums = {1,8,6,2,5,4,8,3,7};
    int ans = maxArea(nums);

    System.out.println(ans);
  }
}
