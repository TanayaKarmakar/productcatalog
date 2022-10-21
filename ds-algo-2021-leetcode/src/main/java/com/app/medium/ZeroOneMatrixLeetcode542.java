package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 19/10/22
 * @project ds-algo-2021-leetcode
 */
public class ZeroOneMatrixLeetcode542 {
  private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

  private static int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] result = new int[m][n];
    Queue<int[]> q = new LinkedList<>();
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(mat[i][j] == 0)
          q.add(new int[]{i,j});
      }
    }


    while(!q.isEmpty()) {
      int[] current = q.poll();

      for(int j = 0; j < directions.length; j++) {
        int newRow = current[0] + directions[j][0];
        int newCol = current[1] + directions[j][1];

        if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
        || mat[newRow][newCol] == 0)
          continue;
        int dist = 1 + result[current[0]][current[1]];
        if(result[newRow][newCol] != 0 && dist > result[newRow][newCol])
          continue;
        result[newRow][newCol] = dist;
        q.add(new int[]{newRow, newCol});
      }
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
