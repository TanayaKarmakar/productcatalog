package com.app.medium;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class PrisonCellsAfterNDaysLeetcode957 {
  private static int[] prisonAfterNDays(int[] cells, int n) {
    int[][] prison = new int[8][cells.length];

    prison[0] = cells;
    for(int i = 1; i < 8; i++) {
      for(int j = 1; j < cells.length - 1; j++) {
        int prev = prison[i - 1][j - 1];
        int next = prison[i - 1][j + 1];
        if(prev == next) {
          prison[i][j] = 1;
        }
      }
    }

    if(n < 8) {
      return prison[n];
    } else {
      int indx = n / 7;
      if(indx % 2 == 0) {
        return prison[n % 7];
      } else {
        int start = 0;
        int end = cells.length - 1;
        int cellIndx = n % 7;
        while(start <= end) {
          int tmp = prison[cellIndx][start];
          prison[cellIndx][start] = prison[cellIndx][end];
          prison[cellIndx][end] = tmp;
          start++;
          end--;
        }
        return prison[indx];
      }
    }

  }

  public static void main(String[] args) {

  }
}
