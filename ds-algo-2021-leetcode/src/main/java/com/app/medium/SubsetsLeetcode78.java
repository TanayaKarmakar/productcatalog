package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 06/06/23
 * @project ds-algo-2021-leetcode
 */
public class SubsetsLeetcode78 {
  private static List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    int totalLength = (int)Math.pow(2, n);
    List<List<Integer>> result = new ArrayList<>();

    for(int i = 0; i < totalLength; i++) {
      int temp = i;
      int j = 0;
      List<Integer> current = new ArrayList<>();
      while(temp != 0) {
        if((temp & 1) == 1) {
          current.add(nums[j]);
        }
        j++;
        temp = temp >> 1;
      }
      result.add(current);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};

    List<List<Integer>> res = subsets(nums);

    System.out.println(res);
  }
}
