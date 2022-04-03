package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class SubsetsLeetcode78 {
    private static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totalSubset = (int)Math.pow(2, n);

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < totalSubset; i++) {
            int temp = i;
            List<Integer> current = new ArrayList<>();
            int j = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    current.add(nums[j]);
                }
                temp = temp >> 1;
                j++;
            }
            list.add(current);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);

        System.out.println(res);
    }
}
