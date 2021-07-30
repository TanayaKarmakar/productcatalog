package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 28/07/21
 * @project ds-algo-2021
 */
public class ThreeSumLeetcode15 {
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new LinkedHashSet<>();
        for(int i = 0; i < nums.length; i++) {
            twoSum(result, nums[i], i + 1, nums);
        }

        return new ArrayList<>(result);
    }

    private static void twoSum(Set<List<Integer>> result, int num, int start, int[] nums) {
        int end = nums.length - 1;
        while(start < end) {
            int sum = num + nums[start] + nums[end];
            if(sum == 0) {
                List<Integer> curr = new ArrayList<>();
                curr.add(num);
                curr.add(nums[start]);
                curr.add(nums[end]);
                result.add(curr);
                start++;
                end--;
            } else if(sum > 0)
                end--;
            else
                start++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);

        System.out.println(res);
    }
}
