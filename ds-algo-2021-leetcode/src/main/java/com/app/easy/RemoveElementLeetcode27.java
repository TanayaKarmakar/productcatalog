package com.app.easy;

public class RemoveElementLeetcode27 {
    private static int removeElement(int[] nums, int val) {
        int i = -1;
        int n = nums.length;

        for(int j = 0; j < n; j++) {
            if(nums[j] != val) {
                i++;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }

        return (i + 1);
    }

    public static void main(String[] args) {

    }
}
