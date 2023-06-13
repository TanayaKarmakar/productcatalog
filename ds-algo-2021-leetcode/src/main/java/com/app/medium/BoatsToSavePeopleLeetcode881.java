package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/06/23
 * @project ds-algo-2021-leetcode
 */
public class BoatsToSavePeopleLeetcode881 {
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
    int[] nums = {3,2,2,1};
    int limit = 3;

    System.out.println(numRescueBoats(nums, limit));

    nums = new int[]{3,5,3,4};
    limit = 5;

    System.out.println(numRescueBoats(nums, limit));
  }
}
