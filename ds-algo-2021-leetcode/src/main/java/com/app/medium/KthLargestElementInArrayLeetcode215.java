package com.app.medium;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 24/03/22
 * @project ds-algo-2021
 */
public class KthLargestElementInArrayLeetcode215 {
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            pQ.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(pQ.peek() < nums[i]) {
                pQ.poll();
                pQ.add(nums[i]);
            }
        }
        return pQ.peek();
    }

    public static void main(String[] args) {

    }
}
