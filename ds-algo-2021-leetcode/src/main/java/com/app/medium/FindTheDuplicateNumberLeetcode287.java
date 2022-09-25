package com.app.medium;

/**
 * @author t0k02w6 on 22/09/22
 * @project ds-algo-2021-leetcode
 */
public class FindTheDuplicateNumberLeetcode287 {
    private static int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
               break;
        }
        int ptr1 = 0;
        int ptr2 = slow;
        while(ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    public static void main(String[] args) {

    }
}
