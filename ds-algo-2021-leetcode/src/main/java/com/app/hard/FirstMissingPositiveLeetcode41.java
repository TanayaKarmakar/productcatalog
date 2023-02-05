package com.app.hard;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class FirstMissingPositiveLeetcode41 {
  private static int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] <= 0) {
        nums[i] = (n + 1);
      }
    }

    for(int i = 0; i < nums.length; i++) {
      int k = Math.abs(nums[i]);
      if(k - 1 < n && nums[k - 1] > 0) {
        nums[k - 1] = -nums[k - 1];
      }
    }

    for(int i = 0; i < nums.length; i++) {
      if(nums[i] > 0)
        return (i + 1);
    }
    return (n + 1);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,0};
    int ans = firstMissingPositive(nums);

    System.out.println(ans);

    nums = new int[]{3,4,-1,1};
    ans = firstMissingPositive(nums);

    System.out.println(ans);

    nums = new int[] {1};

    ans = firstMissingPositive(nums);
    System.out.println(ans);
  }
}
