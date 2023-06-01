package com.app.medium;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class PairOfSongsTotalDivisibleBy60Leetcode1010 {
  private static int numPairsDivisibleBy60(int[] time) {
    int[] count = new int[60];

    for(int i = 0; i < time.length; i++) {
      count[time[i] % 60]++;
    }

    int result = 0;
    for(int i = 1; i <= 29; i++) {
      result += count[i] * count[60 - i];
    }
    result += ((count[0] * (count[0] - 1)) / 2) + ((count[30] * (count[30] - 1)) / 2);

    return result;
  }

  public static void main(String[] args) {
    int[] time = {30,20,150,100,40};

    int ans = numPairsDivisibleBy60(time);

    System.out.println(ans);

    time = new int[] {60, 60, 60};
    ans = numPairsDivisibleBy60(time);

    System.out.println(ans);
  }
}
