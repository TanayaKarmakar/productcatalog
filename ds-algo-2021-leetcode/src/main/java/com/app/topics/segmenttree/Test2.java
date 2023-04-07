package com.app.topics.segmenttree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 12/02/23
 * @project ds-algo-2021
 */
public class Test2 {


  private static int solution(int K, int[][] A) {
    // Implement your solution here
    List<int[]> housePos = new ArrayList<>();
    for(int i = 0; i < A.length; i++) {
      for(int j = 0; j < A[0].length; j++) {
        if(A[i][j] == 1) {
          housePos.add(new int[] {i, j});
        }
      }
    }

    int count = 0;
    for(int i = 0; i < A.length; i++) {
      for(int j = 0; j < A[0].length; j++) {
        if(A[i][j] == 0 && hasKDistFromHouses(housePos, i, j, K))
          count++;
      }
    }
//    Queue<int[]> q = new LinkedList<>();
//    int count = 0;
//    for(int i = 0; i < A.length; i++) {
//      for(int j = 0; j < A[0].length; j++) {
//        if(A[i][j] == 1) {
//          q.add(new int[]{i, j});
//        }
//      }
//    }
//
//    while(!q.isEmpty()) {
//      int[] pos = q.poll();
//      int row = pos[0];
//      int col = pos[1];
//      // keeping col fix, change the row
//
//      boolean builtForRow = false;
//      boolean builtForCol = false;
//      for(int i = 1; i <= K; i++) {
//        if(storeAllPresent(A, row, col, i)) {
//          continue;
//        }
//        int newRow = row + i;
//        if(newRow < A.length && A[newRow][col] == 0 && distanceSatisfies(A, newRow, col, K)) {
//          A[newRow][col] = -1;
//        }
//
//        newRow = row - i;
//        if(newRow >= 0 && A[newRow][col] == 0 && distanceSatisfies(A, newRow, col, K)) {
//          A[newRow][col] = -1;
//        }
//
//        int newCol = col + i;
//        if(newCol < A[0].length && A[row][newCol] == 0 && distanceSatisfies(A, newRow, col, K)) {
//          A[row][newCol] = -1;
//        }
//
//        newCol = col - i;
//        if(newCol >= 0 && A[row][newCol] == 0 && distanceSatisfies(A, newRow, col, K)) {
//          A[row][newCol] = -1;
//        }
//
//      }
//      //keeping column fixed and change the row



    return count;
  }

  private static boolean hasKDistFromHouses(List<int[]> housePos, int i, int j, int k) {
    for(int[] current: housePos) {
      int row = current[0];
      int col = current[1];
      int rowDist = Math.abs(i - row);
      int colDist = Math.abs(j - col);
      double dist = Math.sqrt((rowDist * rowDist) + (colDist * colDist));
      System.out.println("i - " + i + ": j - " + j + ": dist - " + dist);
      if(dist > (double)k)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] grid = {{0,1},{0,0}};

    int k = 1;

    int ans = solution(k, grid);

    System.out.println(ans);

    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }
}
