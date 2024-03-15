package com.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KThSmallestElementInASortedMatrixLeetcode378 {
    private static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int m = matrix.length;
        int n = matrix[0].length;
        int totalElements = m * n;

        for(int i = 0; i < k; i++) {
            int row = i / n;
            int col = i % n;
            pQ.add(matrix[row][col]);
        }

        for(int i = k; i < totalElements; i++) {
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

    }
}
