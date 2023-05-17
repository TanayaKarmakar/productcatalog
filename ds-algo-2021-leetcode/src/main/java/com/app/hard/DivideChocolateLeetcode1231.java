package com.app.hard;

/**
 * @author t0k02w6 on 14/05/23
 * @project ds-algo-2021-leetcode
 */
public class DivideChocolateLeetcode1231 {
  private static int maximizeSweetness(int[] sweetness, int k) {
    int totalSum = sweetness.length;
    for(int i = 0; i < sweetness.length; i++) {
      totalSum += sweetness[i];
    }

    int start = 0;
    int end = totalSum;

    while(start <= end) {
      int mid = (start + end) >> 1;
      if(canDivide(sweetness, mid, k + 1))
        start = mid + 1;
      else
        end = mid - 1;
    }
    return start - 1;
  }

  private static boolean canDivide(int[] sweetness, int mid, int k) {
    int count = 0;
    int sum = 0;
    for(int i = 0; i < sweetness.length; i++) {
      sum += sweetness[i];
      if(sum >= mid) {
        count++;
        sum = 0;
      }
    }
    return count >= k;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7,8,9};
    int k = 5;

    int ans = maximizeSweetness(nums, k);

    System.out.println(ans);
  }
}
