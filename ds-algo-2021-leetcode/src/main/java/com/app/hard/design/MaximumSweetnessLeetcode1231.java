package com.app.hard.design;

/**
 * @author t0k02w6 on 19/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumSweetnessLeetcode1231 {
  private static int maximizeSweetness(int[] sweetness, int k) {
    int totalSum = 0;
    for(int el: sweetness) {
      totalSum += el;
    }

    int start = 1;
    int end = totalSum;
    int finalAns = -1;
    while(start <= end) {
      int mid = (start + end) >> 1;
      int cutsCount = getCutsCount(sweetness, mid);
      if(cutsCount >= k + 1) {
        start = mid + 1;
      }
      else
        end = mid - 1;
    }
    return start - 1;
  }

  private static int getCutsCount(int[] sweetness, int sweetnessSum) {
    int currentSum = 0;
    int count = 0;
    for(int i = 0; i < sweetness.length; i++) {
      currentSum += sweetness[i];
      if(currentSum >= sweetnessSum) {
        count++;
        currentSum = 0;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] sweetness = {1,2,3,4,5,6,7,8,9};
    int k = 5;

    int ans = maximizeSweetness(sweetness, k);

    System.out.println(ans);
  }
}
