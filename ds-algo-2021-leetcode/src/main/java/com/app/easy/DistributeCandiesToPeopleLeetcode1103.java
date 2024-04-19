package com.app.easy;

import java.util.Arrays;

public class DistributeCandiesToPeopleLeetcode1103 {
    private static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int candyCount = 1;
        int i = 0;
        while(candies > 0) {
            result[i] += Math.min(candies, candyCount);
            candies -= candyCount;
            candyCount++;
            i = (i + 1) % num_people;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = distributeCandies(10, 3);
        System.out.println(Arrays.toString(result));
    }
}
