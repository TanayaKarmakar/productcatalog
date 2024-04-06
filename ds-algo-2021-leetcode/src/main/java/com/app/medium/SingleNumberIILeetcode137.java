package com.app.medium;

public class SingleNumberIILeetcode137 {
    private static int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int countOfOne = 0;
            for(int j = 0; j < nums.length; j++) {
                int currentMask = (nums[j] >> i);
                if((currentMask & 1) == 1) {
                    countOfOne++;
                }
            }
            result = (result << 1);
            if(countOfOne % 3 != 0) {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
    }
}
