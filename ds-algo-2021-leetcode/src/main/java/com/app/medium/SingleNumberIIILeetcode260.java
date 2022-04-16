package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 13/04/22
 * @project ds-algo-2021
 */
public class SingleNumberIIILeetcode260 {
    private static int[] singleNumber(int[] nums) {
        int groupXor = 0;
        for(int i = 0; i < nums.length; i++) {
            groupXor = groupXor ^ nums[i];
        }

        int setBit = 0;
        for(setBit = 0; setBit < 32; setBit++) {
            if((groupXor & (1 << setBit)) > 0)
                break;
        }

        int group1Xor = 0;
        int group2Xor = 0;

        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & (1 << setBit)) > 0) {
                group1Xor = group1Xor ^ nums[i];
            } else {
                group2Xor = group2Xor ^ nums[i];
            }
        }
        return new int[] {group1Xor, group2Xor};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] ans = singleNumber(nums);

        System.out.println(Arrays.toString(ans));
    }
}
