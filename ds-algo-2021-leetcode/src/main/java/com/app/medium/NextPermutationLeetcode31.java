package com.app.medium;

public class NextPermutationLeetcode31 {
    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while(i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }

        if(i >= 0) {
            for(int j = n - 1; j >= 0; j--) {
                if(nums[j] > nums[i]) {
                    swap(nums, j, i);
                    break;
                }
            }
        }


        int start = i + 1;
        int end = n - 1;
        while(start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
