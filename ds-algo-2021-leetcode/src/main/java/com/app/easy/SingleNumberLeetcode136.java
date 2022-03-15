package com.app.easy;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class SingleNumberLeetcode136 {
    private static int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
