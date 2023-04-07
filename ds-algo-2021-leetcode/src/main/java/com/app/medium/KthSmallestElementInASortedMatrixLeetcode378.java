package com.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 06/04/23
 * @project ds-algo-2021-leetcode
 */
public class KthSmallestElementInASortedMatrixLeetcode378 {
  private static int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;

    int totalItems = m * n;

    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    for(int i = 0; i < k; i++) {
      int row = (i / n);
      int col = (i % n);
      pQ.add(matrix[row][col]);
    }

    for(int i = k; i < totalItems; i++) {
      int row = (i / n);
      int col = (i % n);
      if(!pQ.isEmpty() && pQ.peek() > matrix[row][col]) {
        pQ.remove();
        pQ.add(matrix[row][col]);
      }
    }

    return pQ.peek();
  }

  public static void main(String[] args) {

  }
}
