package com.app.medium;

public class TheMazeLeetcode490 {
    private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
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
        if(visited[sr][sc]) {
            return false;
        }
        visited[sr][sc] = true;
        for(int i = 0; i < directions.length; i++) {
            int newRow = sr;
            int newCol = sc;
            while(isValid(maze, newRow + directions[i][0], newCol + directions[i][1], m, n)) {
                newRow += directions[i][0];
                newCol += directions[i][1];
            }
            if(hasPathRec(maze, visited, newRow, newCol, dr, dc, m, n))
                return true;
        }
        return false;
    }

    private static boolean isValid(int[][] maze, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;
        else if(maze[i][j] == 1)
            return false;
        return true;
    }


    public static void main(String[] args) {

    }
}
