package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
class SparseVector {
  Map<Integer, Integer> map;

  SparseVector(int[] nums) {
    map = new HashMap<>();
    processArray(nums);
  }

  private void processArray(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != 0) {
        map.put(i, nums[i]);
      }
    }
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
    Map<Integer, Integer> map2 = vec.map;
    int ans = 0;
    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
      if(map2.containsKey(entry.getKey())) {
        ans += (entry.getValue() * map2.get(entry.getKey()));
      }
    }
    return ans;
  }
}

public class DotProductOfTwoSparseVectorLeetcode1570 {

  public static void main(String[] args) {
    int[] nums1 = {1,0,0,2,3};
    int[] nums2 = {0,3,0,4,0};
    SparseVector v1 = new SparseVector(nums1);
    SparseVector v2 = new SparseVector(nums2);

    int ans = v1.dotProduct(v2);

    System.out.println(ans);
  }
}
