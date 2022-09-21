package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */

class SparseVector {
    int[] nums;
    Map<Integer, Integer> map = new HashMap<>();

    SparseVector(int[] nums) {
        this.nums = nums;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        Map<Integer, Integer> map2 = vec.map;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(map2.containsKey(key)) {
                ans += (value * map2.get(key));
            }
        }
        return ans;
    }
}

public class DotProductOfTwoSparseVectorLeetcode1570 {
    public static void main(String[] args) {

    }
}
