package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class ShortestPathBinaryMatrixLeetcode1091 {
    static int[][] directions = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{1, -1},{-1,1},{1,1}};

    private static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        if(grid[0][0] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int pathVisited = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] rem = q.poll();
                visited[rem[0]][rem[1]] = true;
                if(rem[0] == m - 1 && rem[1] == n - 1)
                    return pathVisited;
                for(int j = 0; j < directions.length; j++) {
                    int newRow = rem[0] + directions[j][0];
                    int newCol = rem[1] + directions[j][1];

                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
                            || grid[newRow][newCol] == 1 || visited[newRow][newCol])
                        continue;
                    q.add(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }
            pathVisited++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1,0}};

        int ans = shortestPathBinaryMatrix(grid);

        System.out.println(ans);
    }
}
