package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class SubsetsIILeetcode90 {
  private static List<List<Integer>> subsetsWithDup(int[] nums) {
    if(nums.length == 0)
      return new ArrayList<>();
    Arrays.sort(nums);
    Set<List<Integer>> intermediateRes = new HashSet<>();
    int n = nums.length;
    int totalCombination = (int)Math.pow(2, n);

    for(int i = 0; i < totalCombination; i++) {
      int current = i;
      List<Integer> currentResult = new ArrayList<>();
      int j = 0;
      while(current != 0) {
        if((current & 1) == 1) {
          currentResult.add(nums[j]);
        }
        current = current >> 1;
        j++;
      }
      intermediateRes.add(currentResult);
    }
    return new ArrayList<>(intermediateRes);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,2};
    List<List<Integer>> result = subsetsWithDup(nums);

    System.out.println(result);
  }
}
