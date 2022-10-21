package com.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;


/**
 * @author t0k02w6 on 25/09/22
 * @project ds-algo-2021-leetcode
 */
public class KthSmallestElementInASortedMatrixLeetcode378 {
    private static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lastIndx = (m - 1) * n + (n - 1);
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < k; i++) {
            int row = i / n;
            int col = i % n;
            q.add(matrix[row][col]);
        }

        for(int i = k; i < lastIndx; i++) {
            int row = i / n;
            int col = i % n;
            if(matrix[row][col] < q.peek()) {
                q.remove();
                q.add(matrix[row][col]);
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {

    }
}
