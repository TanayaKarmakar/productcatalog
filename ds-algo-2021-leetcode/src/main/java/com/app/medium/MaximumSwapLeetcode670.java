package com.app.medium;

/**
 * @author t0k02w6 on 03/04/22
 * @project ds-algo-2021
 */
public class MaximumSwapLeetcode670 {
    private static int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] nums = new char[str.length()];

        for(int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i);
        }

        int maxNum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    swap(nums, i, j);
                    Integer newNum = Integer.parseInt(new String(nums));
                    maxNum = Integer.max(newNum, maxNum);
                    swap(nums, i, j);
                }
            }
        }
        return maxNum == Integer.MIN_VALUE ? num: maxNum;
    }

    private static void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int num = 98368;
        int ans = maximumSwap(num);

        System.out.println(ans);
    }
}
