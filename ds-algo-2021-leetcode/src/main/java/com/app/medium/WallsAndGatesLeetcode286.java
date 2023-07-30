package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 05/07/23
 * @project ds-algo-2021-leetcode
 */
public class WallsAndGatesLeetcode286 {
  private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

  private static void wallsAndGates(int[][] rooms) {
    int m = rooms.length;
    int n = rooms[0].length;

    Queue<int[]> q = new LinkedList<>();

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(rooms[i][j] == 0) {
          q.add(new int[]{i, j});
        }
      }
    }

    while(!q.isEmpty()) {
      int[] currentPos = q.poll();

      for(int i = 0; i < directions.length; i++) {
        int newRow = currentPos[0] + directions[i][0];
        int newCol = currentPos[1] + directions[i][1];

        if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
        || rooms[newRow][newCol] == 0 || rooms[newRow][newCol] == -1)
          continue;

        int dist =  1 + rooms[currentPos[0]][currentPos[1]];
        if(rooms[newRow][newCol] == Integer.MAX_VALUE || dist < rooms[newRow][newCol]) {
          rooms[newRow][newCol] = dist;
          q.add(new int[]{newRow, newCol});
        }
      }
    }
  }

  public static void main(String[] args) {

  }
}
