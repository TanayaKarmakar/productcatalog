package com.app.medium;

/**
 * @author t0k02w6 on 31/03/22
 * @project ds-algo-2021
 */
public class JumpGameLeetcode55 {
    private static boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int n = nums.length;
        int lastIndx = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            if(i + nums[i] >= lastIndx)
                lastIndx = i;
        }
        return lastIndx == 0;
    }

    public static void main(String[] args) {

    }
}
