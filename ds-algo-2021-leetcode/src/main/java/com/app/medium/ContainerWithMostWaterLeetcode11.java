package com.app.medium;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
public class ContainerWithMostWaterLeetcode11 {
    private static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxTotal = 0;
        while(left < right) {
            int min = Integer.min(height[left], height[right]);
            int currentTotal = min * (right - left);
            maxTotal = Integer.max(currentTotal, maxTotal);
            if(min == height[left])
                left++;
            else
                right--;
        }
        return maxTotal;
    }

    public static void main(String[] args) {

    }
}
