package com.app.medium;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
 */
public class ContainerWithMostWaterLeetcode11 {
    private static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = Integer.MIN_VALUE;

        while(left < right) {
            int currentVal = Integer.min(height[left], height[right]) * (right - left);
            max = Integer.max(max, currentVal);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int total = maxArea(nums);

        System.out.println(total);
    }
}
