package com.app.medium;

import java.util.Arrays;

public class BoatsToSavePeopleLeetcode881 {
    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;

        int count = 0;
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
        System.out.println(numRescueBoats(new int[]{1,2}, 3));
        System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3));
    }
}
