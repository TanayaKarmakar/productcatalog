package com.app.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class ZeroOneMatrixLeetcode542 {
  private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

  private static int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] finalMatrix = new int[m][n];
    Queue<int[]> q = new LinkedList<>();

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(mat[i][j] == 0) {
          q.add(new int[]{i, j});
        }
      }
    }

    while(!q.isEmpty()) {
      int[] pos = q.poll();

      for(int i = 0; i < directions.length; i++) {
        int currentRow = pos[0] + directions[i][0];
        int currentCol = pos[1] + directions[i][1];
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n
        || mat[currentRow][currentCol] == 0)
          continue;
        int dist = 1 + finalMatrix[pos[0]][pos[1]];
        if(finalMatrix[currentRow][currentCol] != 0 && dist > finalMatrix[currentRow][currentCol])
          continue;
        finalMatrix[currentRow][currentCol] = dist;
        q.add(new int[]{currentRow, currentCol});
      }
    }
    return finalMatrix;
  }

  public static void main(String[] args) {
    int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};

    int[][] finalMatrix = updateMatrix(matrix);

    for(int i = 0; i < finalMatrix.length; i++) {
      System.out.println(Arrays.toString(finalMatrix[i]));
    }
  }
}
