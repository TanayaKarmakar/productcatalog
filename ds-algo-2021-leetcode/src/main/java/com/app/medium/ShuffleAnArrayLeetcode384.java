package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 27/04/23
 * @project ds-algo-2021-leetcode
 */

public class ShuffleAnArrayLeetcode384 {

  static class Solution {
    List<int[]> shuffledArray;
    int indx;

    public Solution(int[] nums) {
      indx = 0;
      int n = nums.length;
      shuffledArray = new ArrayList<>();
      createPermutation(shuffledArray, nums, 0, n - 1);
    }

    public int[] reset() {
      indx = 0;
      return shuffledArray.get(indx);
    }

    public int[] shuffle() {
      indx = (indx + 1) % shuffledArray.size();
      return shuffledArray.get(indx);
    }

    private void createPermutation(List<int[]> shuffledArray, int[] nums, int start, int end) {
      if(start == end) {
        int[] newArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
          newArray[i] = nums[i];
        }
        shuffledArray.add(newArray);
      }

      for(int i = start; i <= end; i++) {
        swap(nums, start, i);
        createPermutation(shuffledArray, nums, start + 1, end);
        swap(nums, start, i);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution(new int[]{1,2,3});

    System.out.println(Arrays.toString(s.shuffle()));
    System.out.println(Arrays.toString(s.reset()));
  }
}
