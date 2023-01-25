package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 29/11/22
 * @project ds-algo-2021
 */
public class PrisonCellsAfterNDaysLeetcode957 {
  private static int[] prisonAfterNDays(int[] cells, int n) {
    int[][] cellMap = new int[8][8];
    cellMap[0] = cells;

    for(int i = 1; i < 8; i++) {
      int[] currentCell = new int[8];
      for(int j = 1; j < 7; j++) {
        int prev = cellMap[i - 1][j - 1];
        int next = cellMap[i - 1][j + 1];
        if(prev == next) {
          currentCell[j] = 1;
        }
      }
      cellMap[i] = currentCell;
    }

    cellMap = Arrays.copyOfRange(cellMap, 1, cellMap.length);

    int div = (n - 1) / cellMap.length;
    int[] target = cellMap[(n - 1) % cellMap.length];
    if(div % 2 == 0) {
      return target;
    } else {
      int start = 0;
      int end = target.length - 1;
      while(start < end) {
        int tmp = target[start];
        target[start] = target[end];
        target[end] = tmp;
        start++;
        end--;
      }
      return target;
    }
  }

  public static void main(String[] args) {
    int[] cells = {0,1,0,1,1,0,0,1};
    int n = 7;

    int[] ans = prisonAfterNDays(cells, n);

    System.out.println(Arrays.toString(ans));
  }
}
