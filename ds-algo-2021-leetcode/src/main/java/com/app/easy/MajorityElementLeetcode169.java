package com.app.easy;

public class MajorityElementLeetcode169 {
    private static int majorityElement(int[] nums) {
        int majIndx = 0;
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[majIndx]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    majIndx = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[majIndx] == nums[i])
                count++;
        }

        if(count > nums.length / 2)
            return nums[majIndx];
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
