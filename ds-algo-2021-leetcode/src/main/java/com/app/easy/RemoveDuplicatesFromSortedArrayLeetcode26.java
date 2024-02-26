package com.app.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayLeetcode26 {
    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int count = 1;
            int j = i + 1;
            while(j < n && nums[i] == nums[j]) {
                count++;
                j++;
            }

            if(count > 1) {
                j = i + 1;
                int end = i + count;
                while(j < end) {
                    nums[j] = Integer.MIN_VALUE;
                    j++;
                }
            }
        }

        int i = -1;
        for(int j = 0; j < n; j++) {
            if(nums[j] != Integer.MIN_VALUE) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int ans = removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(ans);

        nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        ans = removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(ans);

    }
}
