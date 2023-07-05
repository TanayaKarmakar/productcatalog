package com.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 02/07/23
 * @project ds-algo-2021-leetcode
 */
public class KthSmallestElementInASortedMatrixLeetcode378 {
  private static int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

    int m = matrix.length;
    int n = matrix[0].length;

    int total = (m * n);

    for(int i = 0; i < k; i++) {
      int row = i / n;
      int col = i % n;
      pQ.add(matrix[row][col]);
    }

    for(int i = k; i < total; i++) {
      int row = i / n;
      int col = i % n;
      if(pQ.peek() > matrix[row][col]) {
        pQ.poll();
        pQ.add(matrix[row][col]);
      }
    }
    return pQ.peek();
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
    int k = 8;

    int ans = kthSmallest(matrix, k);

    System.out.println(ans);
  }
}
