package com.app.topics.segmenttree;

import java.util.Arrays;

/**
 * @author t0k02w6 on 12/02/23
 * @project ds-algo-2021
 */
public class Test4 {
  private static int solution(int[] A) {
    // Implement your solution here
    int n = A.length;
    int[] maxA = new int[n];
    int[] copy = new int[n];

    //int maxNumber = A[0];
    copy[0] = A[0];
    maxA[0] = A[0];
    for(int i = 1; i < n; i++) {
      maxA[i] = Integer.max(maxA[i - 1], A[i]);
      copy[i] = A[i];
    }

    Arrays.sort(copy);
    int count = 0;

    //System.out.println(Arrays.toString(maxA));
    for(int i = 0; i < n; i++) {
      if(maxA[i] == copy[i])
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{2,4,1,6,5,9,7}));
    System.out.println(solution(new int[]{2,1,6,4,3,7}));
    System.out.println(solution(new int[]{4,3,2,6,1}));
  }
}
