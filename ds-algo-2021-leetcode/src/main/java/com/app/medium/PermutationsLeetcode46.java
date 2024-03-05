package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsLeetcode46 {
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRec(nums, 0, result);

        return result;
    }

    private static void permuteRec(int[] nums, int indx, List<List<Integer>> result) {
        if(indx >= nums.length) {
            List<Integer> currentResult = new ArrayList<>();
            for(int num: nums) {
                currentResult.add(num);
            }
            result.add(currentResult);
            return;
        }

        for(int i = indx; i < nums.length; i++) {
            swap(nums, indx, i);
            permuteRec(nums, indx + 1, result);
            swap(nums, indx, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[]{1,2,3});

        System.out.println(result);
    }
}
