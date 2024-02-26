package com.app.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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

        int[] res = new int[k];
        int i = 0;
        while(!pQ.isEmpty() && k-- > 0) {
            res[i++] = pQ.poll().key;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
