package com.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 25/06/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumKnightMovesLeetcode1197 {
  private static int[][] directions = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};

  private static int minKnightMoves(int x, int y) {
    if(x == 1 && y == 1)
      return 2;
    int count = 0;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0,0});
    Set<String> visited = new HashSet<>();
    visited.add(0 + "-" + 0);

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int [] currentPos = q.poll();
        int r = currentPos[0];
        int c = currentPos[1];
        visited.add(r + "-" + c);
        if(r == x && c == y)
          return count;
        for(int j = 0; j < directions.length; j++) {
          int newRow = r + directions[j][0];
          int newCol = c + directions[j][1];
          if(newRow < 0 || newRow > 300 || newCol < 0 || newCol > 300)
            continue;
          if(!visited.contains(newRow + "-" + newCol)) {
            q.add(new int[]{newRow, newCol});
            visited.add(newRow + "-" + newCol);
          }
        }
      }
      count++;
    }
    return -1;
  }

  public static void main(String[] args) {
    int ans = minKnightMoves(2,1);

    System.out.println(ans);

    ans = minKnightMoves(5, 5);
    System.out.println(ans);
  }
}
