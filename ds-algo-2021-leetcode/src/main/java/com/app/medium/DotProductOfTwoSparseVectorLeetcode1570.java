package com.app.medium;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectorLeetcode1570 {

    static class SparseVector {
        Map<Integer, Integer> map;

        SparseVector(int[] nums) {
            map = new HashMap<>();
            processArray(nums);
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int ans = 0;
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if(vec.map.containsKey(entry.getKey())) {
                    ans += entry.getValue() * vec.map.get(entry.getKey());
                }
            }
            return ans;
        }

        private void processArray(int[] nums) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    map.put(i, nums[i]);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
