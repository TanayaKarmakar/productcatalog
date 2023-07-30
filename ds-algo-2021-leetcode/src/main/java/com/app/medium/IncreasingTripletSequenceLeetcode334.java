package com.app.medium;

/**
 * @author t0k02w6 on 05/07/23
 * @project ds-algo-2021-leetcode
 */
public class IncreasingTripletSequenceLeetcode334 {
  private static boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    int n = nums.length;

    for(int i = 0; i < n; i++) {
      int third = nums[i];
      if(third <= first) {
        first = third;
      } else if(third <= second) {
        second = third;
      } else
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};

    boolean ans = increasingTriplet(nums);

    System.out.println(ans);

    nums = new int[]{2,1,5,0,4,6};

    ans = increasingTriplet(nums);

    System.out.println(ans);
  }
}
