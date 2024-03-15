package com.app.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixLeetcode542 {
    private static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();

        int m = mat.length;
        int n = mat[0].length;
        for(int i= 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] finalMatrix = new int[m][n];
        while(!queue.isEmpty()) {
            int[] remNode = queue.poll();

            for(int j = 0; j < directions.length; j++) {
                int newRow = remNode[0] + directions[j][0];
                int newCol = remNode[1] + directions[j][1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || mat[newRow][newCol] == 0)
                    continue;
                int newDist = 1 + finalMatrix[remNode[0]][remNode[1]];
                if(finalMatrix[newRow][newCol] != 0 && newDist > finalMatrix[newRow][newCol])
                    continue;

                finalMatrix[newRow][newCol] = newDist;
                queue.add(new int[]{newRow, newCol});
            }
        }

        return finalMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] ans = updateMatrix(matrix);

        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
