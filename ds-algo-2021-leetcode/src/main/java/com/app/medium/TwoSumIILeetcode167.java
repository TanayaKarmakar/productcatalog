package com.app.medium;

/**
 * @author t0k02w6 on 13/04/22
 * @project ds-algo-2021
 */
public class TwoSumIILeetcode167 {
    private static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target)
                return new int[]{start + 1, end + 1};
            else if(sum > target)
                end--;
            else
                start++;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

    }
}
