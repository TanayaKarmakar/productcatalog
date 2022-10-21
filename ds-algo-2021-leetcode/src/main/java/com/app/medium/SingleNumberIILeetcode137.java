package com.app.medium;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class SingleNumberIILeetcode137 {
  private static int singleNumber(int[] nums) {
    int result = 0;
    for(int i = 31; i >= 0; i--) {
      int countOfOne = 0;
      for(int j = 0; j < nums.length; j++) {
        int mask = nums[j] >> i;
        if((mask & 1) == 1) {
          countOfOne++;
        }
      }
      result = result << 1;
      if(countOfOne % 3 != 0) {
        result += 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,3,2};
    int ans = singleNumber(nums);

    System.out.println(ans);
  }
}
