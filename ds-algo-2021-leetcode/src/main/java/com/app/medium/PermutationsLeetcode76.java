package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class PermutationsLeetcode76 {
  private static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    permuteRec(nums, result, 0, nums.length - 1);
    return result;
  }

  private static void permuteRec(int[] nums, List<List<Integer>> result,  int left, int right) {
    if(left > right) {
      List<Integer> newRow = new ArrayList<>();
      for(int el: nums) {
        newRow.add(el);
      }
      result.add(newRow);
      return;
    }

    for(int i = left; i <= right; i++) {
      swap(nums, i, left);
      permuteRec(nums, result, left + 1, right);
      swap(nums, i, left);
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    System.out.println(permute(new int[] {1,2,3}));
  }
}
