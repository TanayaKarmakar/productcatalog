package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 19/10/22
 * @project ds-algo-2021-leetcode
 */
public class SurroundedRegionsLeetcode130 {
  private static void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;

    List<int[]> points = new ArrayList<>();
    for(int i = 0; i < m; i++) {
      points.add(new int[]{i, 0});
      points.add(new int[]{i, n - 1});
    }

    for(int j = 0; j < n; j++) {
      points.add(new int[]{0, j});
      points.add(new int[]{m - 1, j});
    }

    for(int[] current: points) {
      dfs(board, current[0], current[1], m, n);
    }

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] == 'E')
          board[i][j] = 'O';
        else if(board[i][j] == 'O')
          board[i][j] = 'X';
      }
    }
  }

  private static void dfs(char[][] board, int i, int j, int m, int n) {
    if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
      return;
    board[i][j] = 'E';
    dfs(board, i - 1, j, m, n);
    dfs(board, i + 1, j, m, n);
    dfs(board, i, j + 1, m, n);
    dfs(board, i, j - 1, m, n);
  }

  public static void main(String[] args) {

  }
}
