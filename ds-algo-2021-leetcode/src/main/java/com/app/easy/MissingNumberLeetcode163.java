package com.app.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class MissingNumberLeetcode163 {
    private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) {
            if(lower != upper) {
                res.add(lower + "->" + upper);
            } else {
                res.add(lower + "");
            }
            return res;
        }

        if(nums[0] != lower) {
            int val1 = lower;
            int val2 = nums[0] - 1;
            if(val1 != val2) {
                res.add(val1 + "->" + val2);
            }
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] > 1) {
                int val1 = nums[i - 1] + 1;
                int val2 = nums[i] - 1;
                if(val1 != val2) {
                    res.add(val1 + "->" + val2);
                } else {
                    res.add(val1 + "");
                }
            }
        }
        if(nums[nums.length - 1] != upper) {
            int val1 = nums[nums.length - 1] + 1;
            if(val1 != upper) {
                res.add(val1 + "->" + upper);
            } else {
                res.add(val1 + "");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        List<String> res = findMissingRanges(nums, lower, upper);

        System.out.println(res);
    }
}
