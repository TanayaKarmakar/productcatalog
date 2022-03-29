package com.app.medium;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
public class PairOfSongsDurationDivBy60Leetcode1010 {
    private static int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];

        for(int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
            count[time[i]]++;
        }

        int result = 0;
        for(int i = 1; i <= 29; i++) {
            result += count[i] * count[60 - i];
        }

        result += (count[0] * (count[0] - 1)) / 2;
        result += (count[30] * (count[30] - 1)) / 2;

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {30,20,150,100,40};

        int count = numPairsDivisibleBy60(nums);

        System.out.println(count);
    }
}
