package com.app.hard;

/**
 * @author t0k02w6 on 25/01/23
 * @project ds-algo-2021
 */
public class TrappingRainWaterLeetcode42 {
  private static int trap(int[] height) {
    int totalWater = 0;
    int n = height.length - 1;
    int left = 0;
    int right = n;

    int lMax = -1;
    int rMax = -1;
    while(left < right) {
      if(height[left] < height[right]) {
        lMax = Integer.max(lMax, height[left]);
        totalWater += (lMax - height[left]);
        left++;
      } else {
        rMax = Integer.max(rMax, height[right]);
        totalWater += (rMax - height[right]);
        right--;
      }
    }
    return totalWater;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
    int ans = trap(nums);

    System.out.println(ans);
  }
}
