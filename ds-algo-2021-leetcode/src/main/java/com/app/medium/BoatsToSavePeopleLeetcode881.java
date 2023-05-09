package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 09/05/23
 * @project ds-algo-2021-leetcode
 */
public class BoatsToSavePeopleLeetcode881 {
  private static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int n = people.length;
    int start = 0;
    int end = (n - 1);
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
    int[] people = {3,2,2,1};
    int limit = 3;

    int ans = numRescueBoats(people, limit);

    System.out.println(ans);
  }
}
