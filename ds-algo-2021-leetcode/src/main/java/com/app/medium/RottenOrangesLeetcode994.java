package com.app.medium;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 07/06/23
 * @project ds-algo-2021-leetcode
 */
public class RottenOrangesLeetcode994 {
  private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

  private static int orangesRotting(int[][] grid) {
    Queue<int[]> q = new LinkedList<>();
    int time = -1;

    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 2) {
          q.add(new int[]{i, j});
        }
      }
    }

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int[] point = q.poll();
        for(int j = 0; j < directions.length; j++) {
          int newRow = point[0] + directions[j][0];
          int newCol = point[1] + directions[j][1];
          if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
          || grid[newRow][newCol] != 1)
            continue;
          grid[newRow][newCol] = 2;
          q.add(new int[]{newRow, newCol});
        }
      }
      time++;
    }

    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 1)
          return -1;
      }
    }
    return time == -1?0:time;
  }

  public static void main(String[] args) {
    int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    int ans = orangesRotting(grid);

    System.out.println(ans);

    grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};

    ans = orangesRotting(grid);

    System.out.println(ans);
  }
}
