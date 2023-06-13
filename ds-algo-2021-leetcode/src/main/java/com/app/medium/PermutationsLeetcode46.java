package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 07/06/23
 * @project ds-algo-2021-leetcode
 */
public class PermutationsLeetcode46 {
  private static List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    permutationRec(nums, 0, nums.length - 1, result);

    return result;
  }

  private static void permutationRec(int[] nums, int left, int right, List<List<Integer>> result) {
    if(left > right) {
      List<Integer> res = new ArrayList<>();
      for(int num: nums) {
        res.add(num);
      }
      result.add(res);
      return;
    }

    for(int i = left; i <= right; i++) {
      swap(nums, left, i);
      permutationRec(nums, left + 1, right, result);
      swap(nums, left, i);
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<List<Integer>> result = permute(nums);

    System.out.println(result);
  }
}
