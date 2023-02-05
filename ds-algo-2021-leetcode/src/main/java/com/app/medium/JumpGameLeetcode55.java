package com.app.medium;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class JumpGameLeetcode55 {
  private static boolean canJump(int[] nums) {
    int n = nums.length;
    int lastIndx = n - 1;
    for(int i = n - 2; i >= 0; i--) {
      if(i + nums[i] >= lastIndx)
        lastIndx = i;
    }
    return lastIndx == 0;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,1,1,4};

    System.out.println(canJump(nums));

    nums = new int[] {3,2,1,0,4};
    System.out.println(canJump(nums));
  }
}
