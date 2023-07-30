package com.app.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 23/07/23
 * @project ds-algo-2021-leetcode
 */
public class LargestComponentSizeByCommonFactorLeetcode952 {
  static class Subset {
    int rank;
    int parent;

    public Subset(int parent, int rank) {
      this.parent = parent;
      this.rank = rank;
    }
  }

  private static Subset[] subsets;

  private static void union(int x, int y) {
    int parentX = findParent(x);
    int parentY = findParent(y);
    if(parentX == parentY)
      return;
    if(subsets[parentX].rank < subsets[parentY].rank) {
      subsets[parentX].parent = parentY;
    } else if(subsets[parentY].rank < subsets[parentX].rank) {
      subsets[parentY].parent = parentX;
    } else {
      subsets[parentX].parent = parentY;
      subsets[parentY].rank++;
    }
  }

  private static int findParent(int node) {
    if(subsets[node].parent == node)
      return node;
    subsets[node].parent = findParent(subsets[node].parent);
    return subsets[node].parent;
  }

  private static int largestComponentSize(int[] nums) {
    int max = nums[0];
    for(int i = 1; i < nums.length; i++) {
      max = Integer.max(max, nums[i]);
    }

    subsets = new Subset[max + 1];
    for(int i = 0; i <= max; i++) {
      subsets[i] = new Subset(i, 1);
    }

    for(int i = 0; i < nums.length; i++) {
      for(int factor = 2; factor * factor <= nums[i]; factor++) {
        if(nums[i] % factor == 0) {
          union(nums[i], factor);
          union(nums[i], nums[i] / factor);
        }
      }
    }

    int maxSize = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int parent = findParent(nums[i]);
      map.put(parent, map.getOrDefault(parent, 0) + 1);
      maxSize = Integer.max(maxSize, map.get(parent));
    }
    return maxSize;
  }



  public static void main(String[] args) {
    int[] nums = {4,6,15,35};
    int ans = largestComponentSize(nums);

    System.out.println(ans);
  }
}
