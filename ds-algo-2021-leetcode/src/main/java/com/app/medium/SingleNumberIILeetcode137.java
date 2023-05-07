package com.app.medium;

/**
 * @author t0k02w6 on 27/04/23
 * @project ds-algo-2021-leetcode
 */
public class SingleNumberIILeetcode137 {
  private static int singleNumber(int[] nums) {
    int result = 0;

    for(int j = 31; j >= 0; j--) {
      int count = 0;
      for(int i = 0; i < nums.length; i++) {
        if(((nums[i] >> j) & 1) == 1) {
          count++;
        }
      }
      result = (result << 1);
      if(count % 3 != 0) {
        result += 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    //System.out.println(singleNumber(new int[]{2,3,2,2}));
    System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
  }
}
