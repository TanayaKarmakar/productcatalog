package com.app.medium;

import java.util.*;

public class FourSumLeetcode18 {
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                int start = j + 1;
                int end = nums.length - 1;
                while(start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum == target) {
                        List<Integer> current = new ArrayList<>();
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[start]);
                        current.add(nums[end]);
                        result.add(current);
                        start++;
                        end--;
                    } else if(sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);

        System.out.println(result);
    }
}
