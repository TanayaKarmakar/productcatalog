package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class ThreeSumLeetcode15 {
  private static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    Set<List<Integer>> result = new HashSet<>();

    for(int i = 0; i < nums.length - 2; i++) {
      int start = i + 1;
      int end = nums.length - 1;

      while(start < end) {
        int sum = nums[i] + nums[start] + nums[end];
        if(sum == 0) {
          List<Integer> current = new ArrayList<>();
          current.add(nums[i]);
          current.add(nums[start]);
          current.add(nums[end]);
          result.add(current);
          start++;
          end--;
        } else if(sum < 0) {
          start++;
        } else {
          end--;
        }
      }
    }
    return new ArrayList<>(result);
  }

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};

    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
  }
}
