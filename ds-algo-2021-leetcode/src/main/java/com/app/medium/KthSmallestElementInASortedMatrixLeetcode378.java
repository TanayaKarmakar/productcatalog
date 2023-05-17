package com.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 14/05/23
 * @project ds-algo-2021-leetcode
 */
public class KthSmallestElementInASortedMatrixLeetcode378 {

  private static int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

    int m = matrix.length;
    int n = matrix[0].length;
    int end = (m * n);
    int start = 0;
    for(int i = 0; i < k; i++) {
      int row = (i / n);
      int col = (i % n);
      pQ.add(matrix[row][col]);
    }

    for(int i = k; i < end; i++) {
      int row = (i / n);
      int col = (i % n);
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

    matrix = new int[][] {{-5}};
    k = 2;

    ans = kthSmallest(matrix, k);

    System.out.println(ans);

    matrix = new int[][] {{1,2}, {1,3}};

    ans = kthSmallest(matrix, 1);

    System.out.println(ans);
  }
}
