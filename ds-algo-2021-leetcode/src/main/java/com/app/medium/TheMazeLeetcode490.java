package com.app.medium;

/**
 * @author t0k02w6 on 25/06/23
 * @project ds-algo-2021-leetcode
 */
public class TheMazeLeetcode490 {
  private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

  private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int sr = start[0];
    int sc = start[1];
    int dr = destination[0];
    int dc = destination[1];

    int m = maze.length;
    int n = maze[0].length;
    boolean[][] visited = new boolean[m][n];
    return hasPathRec(maze, visited, sr, sc, dr, dc, m, n);
  }

  private static boolean hasPathRec(int[][] maze, boolean[][] visited, int sr, int sc, int dr, int dc, int m, int n) {
    if(sr == dr && sc == dc)
      return true;
    if(visited[sr][sc])
      return false;
    visited[sr][sc] = true;
    for(int i = 0; i < directions.length; i++) {
      int r = sr;
      int c = sc;
      while(isValid(r + directions[i][0], c + directions[i][1], m, n, maze)) {
        r = r + directions[i][0];
        c = c + directions[i][1];
        if(hasPathRec(maze, visited, r,c,dr, dc, m, n))  {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isValid(int r, int c, int m, int n, int[][] maze) {
    if(r < 0 || r >= m || c < 0 || c >= n)
      return false;
    else if(maze[r][c] == 1)
      return false;
    return true;
  }

  public static void main(String[] args) {
    int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
    int[] start = {0,4};
    int[] end = {4,4};

    boolean ans = hasPath(maze, start, end);

    System.out.println(ans);
  }
}
