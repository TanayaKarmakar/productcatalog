package com.app.medium;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class ContainerWithMostWaterLeetcode11 {
  private static int maxArea(int[] height) {
    int n = height.length - 1;
    int left = 0;
    int right = n;

    int maxArea = 0;
    while(left <= right) {
      int currentMin = Integer.min(height[left], height[right]);
      maxArea = Integer.max(maxArea, currentMin * (right - left));
      if(currentMin == height[left])
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
