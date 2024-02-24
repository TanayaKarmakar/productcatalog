package com.app.medium;

import java.util.PriorityQueue;

public class KLargestElementInAnArrayLeetcode215 {
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            pQ.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > pQ.peek()) {
                pQ.poll();
                pQ.add(nums[i]);
            }
        }
        return pQ.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        int ans = findKthLargest(nums, k);

        System.out.println(ans);
    }
}
