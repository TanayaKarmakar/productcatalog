package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class FourSumLeetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> list = new HashSet<>();
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
                        list.add(current);
                        start++;
                        end--;
                    } else if(sum > target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {

    }
}
