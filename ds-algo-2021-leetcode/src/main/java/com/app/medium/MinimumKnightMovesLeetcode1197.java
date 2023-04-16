package com.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumKnightMovesLeetcode1197 {
  static class PointItem {
    int x;
    int y;

    public PointItem(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      PointItem pointItem = (PointItem) o;
      return x == pointItem.x && y == pointItem.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  private static int[][] directions = {{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1},{-2,-1},{-2,1}};

  private static int minKnightMoves(int x, int y) {
    Queue<PointItem> q = new LinkedList<>();
    q.add(new PointItem(0,0));

    x = Math.abs(x);
    y = Math.abs(y);

    if(x == 1 && y == 1)
      return 2;

    Set<PointItem> visited = new HashSet<>();
    visited.add(new PointItem(0, 0));

    int count = 0;
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        PointItem remItem = q.poll();
        if(remItem.x == x && remItem.y == y)
          return count;
        for(int j = 0; j < directions.length; j++) {
          int newX = remItem.x + directions[j][0];
          int newY = remItem.y + directions[j][1];
          if(newX < 0 || newX > 300 || newY < 0 || newY > 300)
            continue;
          PointItem newItem = new PointItem(newX, newY);
          if(!visited.contains(newItem)) {
            q.add(newItem);
            visited.add(newItem);
          }
        }
      }
      count++;
    }
    return -1;
  }

  public static void main(String[] args) {

  }
}
