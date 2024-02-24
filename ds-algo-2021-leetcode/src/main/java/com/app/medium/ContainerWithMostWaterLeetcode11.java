package com.app.medium;

public class ContainerWithMostWaterLeetcode11 {
    private static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = (n - 1);

        int maxArea = 0;
        while(left < right) {
            int current = 0;
            if(height[left] < height[right]) {
                current = height[left] * (right - left);
                left++;
            } else {
                current = height[right] * (right - left);
                right--;
            }
            maxArea = Integer.max(maxArea, current);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(heights);

        System.out.println(ans);
    }
}
