package com.app.onlinetest.wayfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 05/08/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumMoves {
  private static int getMinimumMoves(List<List<Integer>> maze, int k) {
    int m = maze.size();
    int n = maze.get(0).size();

    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0,0});

    int count = 0;

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int[] currentPos = q.poll();
        if(currentPos[0] == m - 1 && currentPos[1] == n - 1)
          return count;

        for(int x = 1; x <= k; x++) {
          int newRow = currentPos[0] - x;
          int newCol = currentPos[1];
          if(!(newRow < 0 || newRow >= m || maze.get(newRow).get(newCol) == 1 || visited[newRow][newCol])) {
            q.add(new int[]{newRow, newCol});
            visited[newRow][newCol] = true;
          }

          newRow = currentPos[0] + x;
          newCol = currentPos[1];
          if(!(newRow < 0 || newRow >= m || maze.get(newRow).get(newCol) == 1 || visited[newRow][newCol])) {
            q.add(new int[]{newRow, newCol});
            visited[newRow][newCol] = true;
          }

          newRow = currentPos[0];
          newCol = currentPos[1] - x;
          if(!(newCol < 0 || newCol >= n || maze.get(newRow).get(newCol) == 1 || visited[newRow][newCol])) {
            q.add(new int[]{newRow, newCol});
            visited[newRow][newCol] = true;
          }

          newRow = currentPos[0];
          newCol = currentPos[1] + x;
          if(!(newCol < 0 || newCol >= n || maze.get(newRow).get(newCol) == 1 || visited[newRow][newCol])) {
            q.add(new int[]{newRow, newCol});
            visited[newRow][newCol] = true;
          }

        }
      }
      count++;
    }
    return -1;
  }

  public static void main(String[] args) {
    List<List<Integer>> maze = new ArrayList<>();
    List<Integer> row1 = new ArrayList<>();
    row1.addAll(Arrays.asList(0,0,0));

    List<Integer> row2 = new ArrayList<>();
    row2.addAll(Arrays.asList(1,0,0));

    maze.add(row1);
    maze.add(row2);

    int k = 5;

    int count = getMinimumMoves(maze, k);

    System.out.println(count);
  }
}
