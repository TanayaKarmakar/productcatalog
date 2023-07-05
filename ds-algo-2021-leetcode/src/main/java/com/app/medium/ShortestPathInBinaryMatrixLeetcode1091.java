package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 21/06/23
 * @project ds-algo-2021-leetcode
 */
public class ShortestPathInBinaryMatrixLeetcode1091 {
  private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{1,-1},{-1,1}};

  private static int shortestPathBinaryMatrix(int[][] grid) {
    int start = grid[0][0];
    if(start == 1)
      return -1;
    int m = grid.length;
    int n = grid[0].length;
    int count = 1;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0,0});
    grid[0][0] = 2;

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int[] currentPos = q.poll();
        if(currentPos[0] == m - 1 && currentPos[1] == n - 1)
          return count;
        for(int j = 0; j < directions.length; j++) {
          int newRow = currentPos[0] + directions[j][0];
          int newCol = currentPos[1] + directions[j][1];
          if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
          || grid[newRow][newCol] != 0)
            continue;
          grid[newRow][newCol] = 2;
          q.add(new int[]{newRow, newCol});
        }
      }
      count++;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[][] grid = {{0,1},{1,0}};
    int ans = shortestPathBinaryMatrix(grid);
    System.out.println(ans);

    grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
    ans = shortestPathBinaryMatrix(grid);
    System.out.println(ans);
  }
}
