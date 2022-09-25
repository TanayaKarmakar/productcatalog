package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class ShortestPathInBinaryMatrixLeetcode1091 {
    private static int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};

    private static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        if(grid[0][0] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if(curr[0] == m - 1 && curr[1] == n - 1)
                    return count + 1;
                for(int j = 0; j < directions.length; j++) {
                    int newRow = curr[0] + directions[j][0];
                    int newCol = curr[1] + directions[j][1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
                    || grid[newRow][newCol] == 1 || visited[newRow][newCol])
                        continue;
                    visited[newRow][newCol] = true;
                    q.add(new int[] {newRow, newCol});
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        int ans = shortestPathBinaryMatrix(grid);

        System.out.println(ans);
    }
}
