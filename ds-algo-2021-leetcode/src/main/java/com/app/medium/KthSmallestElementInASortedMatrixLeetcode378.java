package com.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class KthSmallestElementInASortedMatrixLeetcode378 {
    private static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < k; i++) {
            int row = i / n;
            int column = i % n;

            pQ.add(matrix[row][column]);
        }

        for(int i = k ; i < (m * n); i++) {
            int row = i / n;
            int column = i % n;
            if(pQ.peek() > matrix[row][column]) {
                pQ.poll();
                pQ.add(matrix[row][column]);
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
