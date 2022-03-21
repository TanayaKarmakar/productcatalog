package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class DistributeCandiesToThePeopleLeetcode1103 {
    private static int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        int[] nums = new int[n];

        int count = 0;
        int i = candies;
        int multiplier = 0;
        while(i > 0) {
            int indx = count % n;
            int addition = (multiplier * n + indx + 1);
            if(indx == n - 1)
                multiplier++;
            if(addition <= i) {
                i = i - addition;
            } else {
                addition = i;
                i = 0;
            }
            nums[indx] += addition;
            count++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int candies = 10;
        int numPeople = 3;

        int[] ans = distributeCandies(candies, numPeople);

        System.out.println(Arrays.toString(ans));

    }
}
