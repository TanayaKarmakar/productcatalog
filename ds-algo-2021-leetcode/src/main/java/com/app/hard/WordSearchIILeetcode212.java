package com.app.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class WordSearchIILeetcode212 {
  private static List<String> findWords(char[][] board, String[] words) {
    Set<String> result = new HashSet<>();
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for(String word: words) {
      clearMatrix(visited);
      for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
          clearMatrix(visited);
          if(board[i][j] == word.charAt(0)) {
            if(isWordPresent(board, word, visited, 0, i, j)) {
              result.add(word);
            }
          }
        }
      }
    }
    return new ArrayList<>(result);
  }

  private static boolean isWordPresent(char[][] board, String word, boolean[][] visited, int indx, int i, int j) {
    if(indx >= word.length())
      return true;
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(indx))
      return false;
    visited[i][j] = true;
    boolean isFound = isWordPresent(board, word, visited, indx + 1, i - 1, j);
    isFound |= isWordPresent(board, word, visited, indx + 1, i + 1, j);
    isFound |= isWordPresent(board, word, visited, indx + 1, i, j - 1);
    isFound |= isWordPresent(board, word, visited, indx + 1, i, j + 1);
    return isFound;
  }

  private static void clearMatrix(boolean[][] visited) {
    for(int i = 0; i < visited.length; i++) {
      for(int j = 0; j < visited[0].length; j++) {
        visited[i][j] = false;
      }
    }
  }

  public static void main(String[] args) {
    char[][] board = {{'o','a','a','n'},{'e','t','a', 'e'},{'i', 'h','k','r'},{'i','f','l','v'}};
    String[] words = {"oath","pea","eat","rain"};

    List<String> result = findWords(board, words);

    System.out.println(result);
  }
}
