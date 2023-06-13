package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class FindAllDuplicatesInAnArrayLeetcode442 {
  private static List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]);
      if(nums[val - 1] < 0) {
        result.add(val);
      } else {
        nums[val - 1] = -nums[val - 1];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {4,3,2,7,8,2,3,1};
    List<Integer> result = findDuplicates(nums);

    System.out.println(result);
  }
}
