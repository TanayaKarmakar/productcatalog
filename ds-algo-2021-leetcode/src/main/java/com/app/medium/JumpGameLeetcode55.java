package com.app.medium;

public class JumpGameLeetcode55 {
    private static boolean canJump(int[] nums) {
        int n = nums.length;
        int lastIndx = (n - 1);

        for(int i = n - 2; i >= 0; i--) {
            if(i + nums[i] >= lastIndx) {
                lastIndx = i;
            }
        }

        return lastIndx == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
