package com.app.medium;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayIILeetcode80 {
    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int j = i + 1;
            while(j < n && nums[i] == nums[j]) {
                j++;
            }

            if(j - i > 2) {
                int k = i + 2;
                while(k < j) {
                    nums[k] = Integer.MAX_VALUE;
                    k++;
                }
            }
            i++;
        }

        i = -1;
        for(int j = 0; j < n; j++) {
            if(nums[j] != Integer.MAX_VALUE) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int ans = removeDuplicates(nums);

        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }
}
