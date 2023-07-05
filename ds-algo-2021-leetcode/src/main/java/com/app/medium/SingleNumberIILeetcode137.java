package com.app.medium;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class SingleNumberIILeetcode137 {
  private static int singleNumber(int[] nums) {
    int result = 0;
    for(int i = 31; i >= 0; i--) {
      int currentMask = i;
      int count = 0;
      for(int j = 0; j < nums.length; j++) {
        if(((nums[j] >> currentMask) & 1) == 1) {
          count++;
        }
      }
      result = result << 1;
      if(count != 0 && count % 3 != 0) {
        result += 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,3,2};
    int ans = singleNumber(nums);

    System.out.println(ans);

    nums = new int[] {0,1,0,1,0,1,99};
    ans = singleNumber(nums);

    System.out.println(ans);
  }
}
