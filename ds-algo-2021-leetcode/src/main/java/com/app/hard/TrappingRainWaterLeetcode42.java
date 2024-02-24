package com.app.hard;

public class TrappingRainWaterLeetcode42 {
    private static int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int total = 0;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;

        while(left <= right) {
            if(height[left] < height[right]) {
                lMax = Integer.max(height[left], lMax);
                total += (lMax - height[left]);
                left++;
            } else {
                rMax = Integer.max(height[right], rMax);
                total += (rMax - height[right]);
                right--;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int total = trap(nums);

        System.out.println(total);
    }
}
