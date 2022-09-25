package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 22/09/22
 * @project ds-algo-2021-leetcode
 */
public class BoatToSavePeopleLeetcode881 {
    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;
        int start = 0;
        int end = people.length - 1;
        while(start <= end) {
            if(people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
