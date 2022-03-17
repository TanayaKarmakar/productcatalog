package com.app.easy;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class MajorityElementLeetcode169 {
    private static int majorityElement(int[] nums) {
        int mIndx = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[mIndx]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    mIndx = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[mIndx])
                count++;
        }

        return (count > nums.length / 2) ? nums[mIndx]: -1;
    }

    public static void main(String[] args) {

    }
}
