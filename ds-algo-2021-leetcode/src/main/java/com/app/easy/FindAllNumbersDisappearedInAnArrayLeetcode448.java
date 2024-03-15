package com.app.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArrayLeetcode448 {
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]);
            if(k - 1 >= 0 && nums[k - 1] > 0) {
                nums[k - 1] = -nums[k - 1];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add((i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(nums);

        System.out.println(result);
    }
}
