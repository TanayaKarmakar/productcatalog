package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class SubsetsIILeetcode90 {
  private static List<List<Integer>> subsetsWithDup(int[] nums) {
    int n = nums.length;
    int totalCombination = (int)Math.pow(2, n);
    Arrays.sort(nums);
    Set<List<Integer>> intermediateResult = new HashSet<>();
    for(int i = 0; i < totalCombination; i++) {
      List<Integer> current = new ArrayList<>();
      int temp = i;
      int j = 0;
      while(temp != 0) {
        if((temp & 1) == 1) {
          current.add(nums[j]);
        }
        j++;
        temp = temp >> 1;
      }
      intermediateResult.add(current);
    }

    return new ArrayList<>(intermediateResult);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,2};
    List<List<Integer>> result = subsetsWithDup(nums);

    System.out.println(result);
  }
}
