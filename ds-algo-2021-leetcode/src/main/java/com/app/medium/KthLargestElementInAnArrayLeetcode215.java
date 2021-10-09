package com.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 09/10/21
 * @project ds-algo-2021
 */
public class KthLargestElementInAnArrayLeetcode215 {
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            pQ.add(nums[i]);
        }

        while(k > 1 && !pQ.isEmpty()) {
            pQ.poll();
            k--;
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
