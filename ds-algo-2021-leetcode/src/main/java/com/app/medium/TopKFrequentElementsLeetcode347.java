package com.app.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 10/06/23
 * @project ds-algo-2021-leetcode
 */
public class TopKFrequentElementsLeetcode347 {
  static class Item implements Comparable<Item> {
    int key;
    int value;

    public Item(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public int compareTo(Item o) {
      if(this.value == o.value)
        return this.key - o.key;
      return o.value - this.value;
    }
  }

  private static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Item> pQ = new PriorityQueue<>();
    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
      pQ.add(new Item(entry.getKey(), entry.getValue()));
    }

    int[] result = new int[k];
    int j = 0;
    while(!pQ.isEmpty() && k-- > 0) {
      result[j++] = pQ.poll().key;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3};
    int k = 2;
    int[] ans = topKFrequent(nums, k);

    System.out.println(Arrays.toString(ans));
  }
}
