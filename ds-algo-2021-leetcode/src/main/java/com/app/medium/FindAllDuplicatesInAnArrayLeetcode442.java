package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class FindAllDuplicatesInAnArrayLeetcode442 {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }

    private static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(i != nums[i] - 1) {
                int tmp = nums[i];
                if(nums[tmp - 1] == tmp)
                    break;
                swap(nums, i, tmp - 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {

    }
}
