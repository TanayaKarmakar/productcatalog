package com.app.medium;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */

class SparseVector {
    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int len = this.nums.length;

        int value = 0;
        for(int i = 0; i < len; i++) {
            value += (nums[i] * vec.nums[i]);
        }
        return value;
    }
}

public class DotProductOfSparseVectorLeetcode1570 {
    public static void main(String[] args) {

    }
}
