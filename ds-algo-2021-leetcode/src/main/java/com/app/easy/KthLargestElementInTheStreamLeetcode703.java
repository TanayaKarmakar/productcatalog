package com.app.easy;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
class KthLargest {
    PriorityQueue<Integer> pQ;
    int k;

    public KthLargest(int k, int[] nums) {
        pQ = new PriorityQueue<>();
        this.k = k;

        int len = Integer.min(k, nums.length);
        for(int i = 0; i < len; i++) {
            pQ.add(nums[i]);
        }

        for(int i = len; i < nums.length; i++) {
            if(pQ.peek() < nums[i]) {
                pQ.poll();
                pQ.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(pQ.isEmpty() || pQ.size() < k) {
            pQ.add(val);
        }
        else if(!pQ.isEmpty() && pQ.peek() < val) {
            pQ.add(val);
            pQ.poll();
        }
        return pQ.peek();
    }
}

public class KthLargestElementInTheStreamLeetcode703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));

    }
}
