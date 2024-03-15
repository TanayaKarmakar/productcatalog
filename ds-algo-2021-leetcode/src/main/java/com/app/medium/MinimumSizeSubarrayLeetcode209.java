package com.app.medium;

public class MinimumSizeSubarrayLeetcode209 {
    private static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = (n + 1);

        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < n) {
            sum += nums[right];
            while(left <= right && sum >= target) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == (n + 1) ? 0: minLen;
    }

    public static void main(String[] args) {

    }
}
