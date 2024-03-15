package com.app.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRangesLeetcode163 {
    private static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if(nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(nums[0] > lower) {
            int start = lower;
            int end = nums[0] - 1;
            result.add(List.of(start, end));
        }

        for(int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            if(next - current > 1) {
                int start = current + 1;
                int end = next - 1;
                if(start <= end) {
                    result.add(List.of(start, end));
                }
            }
        }

        if(nums[nums.length - 1] < upper) {
            int start = nums[nums.length - 1] + 1;
            int end = upper;
            result.add(List.of(start, end));
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        List<List<Integer>> result = findMissingRanges(nums, lower, upper);

        System.out.println(result);
    }
}
