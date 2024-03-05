package com.app.easy;

public class SingleNumberLeetcode136 {
    private static int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
