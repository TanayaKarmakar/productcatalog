package com.app.medium;

import java.util.*;

public class ThreeSumLeetcode15 {
    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {
             int start = i + 1;
             int end = nums.length - 1;
             while(start < end) {
                 int sum = nums[i] + nums[start] + nums[end];
                 if(sum == 0) {
                     List<Integer> currentResult = new ArrayList<>();
                     currentResult.add(nums[i]);
                     currentResult.add(nums[start]);
                     currentResult.add(nums[end]);
                     result.add(currentResult);
                     start++;
                     end--;
                 } else if(sum > 0) {
                     end--;
                 } else {
                     start++;
                 }
             }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);

        nums = new int[]{0,1,1};

        result = threeSum(nums);

        System.out.println(result);
    }
}
