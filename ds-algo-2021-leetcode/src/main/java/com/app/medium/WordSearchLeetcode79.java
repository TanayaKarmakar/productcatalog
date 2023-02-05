package com.app.medium;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class WordSearchLeetcode79 {
  private static boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] == word.charAt(0)) {
          if(isPresent(board, visited, word, i, j, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private static boolean isPresent(char[][] board, boolean[][] visited, String word, int i, int j, int indx) {
    if(indx >= word.length())
      return true;
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
        || board[i][j] != word.charAt(indx))
      return false;
    visited[i][j] = true;
    boolean isFound = isPresent(board, visited, word, i - 1, j, indx + 1);
    isFound |= isPresent(board, visited, word, i + 1, j, indx + 1);
    isFound |= isPresent(board, visited, word, i, j - 1, indx + 1);
    isFound |= isPresent(board, visited, word, i, j + 1, indx + 1);
    visited[i][j] = false;
    return isFound;
  }

  public static void main(String[] args) {

  }
}
