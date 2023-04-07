package com.app.easy;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class MajorityElementLeetcode169 {
  private static int majorityElement(int[] nums) {
    int mIndx = 0;
    int item = nums[0];

    int n = nums.length;
    int count = 1;
    for(int i = 1; i < n; i++) {
      if(item != nums[i]) {
        count--;
        if(count == 0) {
          item = nums[i];
          mIndx = i;
          count = 1;
        }
      } else {
        count++;
      }
    }

    count = 0;
    for(int i = 0; i < n; i++) {
      if(nums[i] == nums[mIndx])
        count++;
    }

    return count > n / 2 ? nums[mIndx]: -1;
  }

  public static void main(String[] args) {
    int[] nums = {3,3,4};
    int ans = majorityElement(nums);

    System.out.println(ans);
  }
}
