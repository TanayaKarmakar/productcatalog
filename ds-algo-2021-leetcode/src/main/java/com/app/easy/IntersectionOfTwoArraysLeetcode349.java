package com.app.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
public class IntersectionOfTwoArraysLeetcode349 {
  private static int[] intersection(int[] nums1, int[] nums2) {
    if(nums1.length < nums2.length)
      return intersection(nums2, nums1);

    Set<Integer> set = new HashSet<>();

    for(int i = 0; i < nums1.length; i++) {
      set.add(nums1[i]);
    }

    Set<Integer> result = new HashSet<>();
    for(int i = 0; i < nums2.length; i++) {
      if(set.contains(nums2[i])) {
        result.add(nums2[i]);
      }
    }

    int[] finalResult = new int[result.size()];

    int j = 0;
    for(Integer el: result) {
      finalResult[j++] = el;
    }
    return finalResult;
  }

  public static void main(String[] args) {

  }
}
