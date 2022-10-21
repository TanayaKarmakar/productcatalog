package com.app.medium;

/**
 * @author t0k02w6 on 20/10/22
 * @project ds-algo-2021-leetcode
 */
public class IncreasingTripletSubsequenceLeetcode334 {
  private static boolean increasingTriplet(int[] nums) {
    if(nums.length <= 2)
      return false;
    int n = nums.length;
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for(int i = 0; i < n; i++) {
      int third = nums[i];
      if(third <= first)
        first = third;
      else if(third <= second)
        second = third;
      else
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    System.out.println(increasingTriplet(nums));

    nums = new int[] {5,4,3,2,1};
    System.out.println(increasingTriplet(nums));

    nums = new int[] {2,1,5,0,4,6};
    System.out.println(increasingTriplet(nums));
  }
}
