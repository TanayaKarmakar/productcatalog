package com.app.medium;


/**
 * @author t0k02w6 on 20/10/22
 * @project ds-algo-2021-leetcode
 */
public class TheMazeLeetcode490 {
  private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

  private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int m = maze.length;
    int n = maze[0].length;
    int sr = start[0];
    int sc = start[1];
    int dr = destination[0];
    int dc = destination[1];

    boolean[][] visited = new boolean[m][n];
    return hasPathRec(maze, visited, sr, sc, dr, dc, m, n);
  }

  private static boolean hasPathRec(int[][] maze, boolean[][] visited, int r, int c, int dr, int dc, int m, int n) {
    if(r == dr && c == dc)
      return true;
    if(visited[r][c] == true)
      return false;
    visited[r][c] = true;
    for(int i = 0; i < directions.length; i++) {
      int newRow = r;
      int newCol = c;

      while(isValid(maze, newRow + directions[i][0], newCol + directions[i][1], m, n)) {
        newRow += directions[i][0];
        newCol += directions[i][1];
      }
      if(hasPathRec(maze, visited, newRow, newCol, dr, dc, m, n))
        return true;
    }
    return false;
  }

  private static boolean isValid(int[][] maze, int r, int c, int m, int n) {
    if(r < 0 || r >= m || c < 0 || c >= n)
      return false;
    else if(maze[r][c] == 1)
      return false;
    return true;
  }

  public static void main(String[] args) {

  }
}
