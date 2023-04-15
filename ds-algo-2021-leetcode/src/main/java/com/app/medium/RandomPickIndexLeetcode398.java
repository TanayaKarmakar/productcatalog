package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author t0k02w6 on 10/04/23
 * @project ds-algo-2021-leetcode
 */



public class RandomPickIndexLeetcode398 {
  static class Solution {
    private int n;
    private Map<Integer, List<Integer>> freqMap;
    private Random rand;

    public Solution(int[] nums) {
      this.n = nums.length;
      rand = new Random();
      freqMap = new HashMap<>();
    }

    public int pick(int target) {
      List<Integer> indices = freqMap.getOrDefault(target, new ArrayList<>());
      if(!indices.isEmpty()) {
        if (indices.size() == 1)
          return indices.get(0);
        int rIndx = rand.nextInt(indices.size());
        return indices.get(rIndx);
      }
      return -1;
    }

    private void populateMap(int[] nums) {
      for(int i = 0; i < nums.length; i++) {
        if(!freqMap.containsKey(nums[i]))
          freqMap.put(nums[i], new ArrayList<>());
        freqMap.get(nums[i]).add(i);
      }
    }
  }

  public static void main(String[] args) {

  }
}
