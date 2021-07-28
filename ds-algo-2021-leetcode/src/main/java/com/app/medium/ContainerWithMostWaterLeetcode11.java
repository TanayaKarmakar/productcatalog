package com.app.medium;

/**
 * @author t0k02w6 on 28/07/21
 * @project ds-algo-2021
 */
public class ContainerWithMostWaterLeetcode11 {
    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right) {
            int curr = 0;
            if(height[left] < height[right]) {
                curr = height[left] * (right - left);
                left++;
            } else {
                curr = height[right] * (right - left);
                right--;
            }
            max = Integer.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(nums);

        System.out.println(ans);
    }
}
