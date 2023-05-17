package com.app.easy;

/**
 * @author t0k02w6 on 14/05/23
 * @project ds-algo-2021-leetcode
 */
public class MissingNumberLeetcode268 {
  private static int missingNumber(int[] nums) {
    int totalSum = 0;
    int arrySum = 0;

    for(int i = 0; i <= nums.length; i++) {
      totalSum += i;
      if(i < nums.length ) {
        arrySum += nums[i];
      }
    }


    return totalSum - arrySum;
  }

  public static void main(String[] args) {

  }
}
