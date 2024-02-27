package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElementsLeetcode658 {
    static class Item implements Comparable<Item> {
        int value;
        int x;

        public Item(int value, int x) {
            this.value = value;
            this.x = x;
        }

        @Override
        public int compareTo(Item o) {
            int diff1 = Math.abs(this.value - this.x);
            int diff2 = Math.abs(o.value - o.x);
            if(diff1 == diff2)
                return this.value - o.value;
            return diff1 - diff2;
        }
    }

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Item> pQ = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            pQ.add(new Item(arr[i], x));
        }

        List<Integer> result = new ArrayList<>();
        while(!pQ.isEmpty() && k-- > 0) {
            result.add(pQ.poll().value);
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        int x = -1;

        List<Integer> res = findClosestElements(nums, k, x);

        System.out.println(res);
    }
}
