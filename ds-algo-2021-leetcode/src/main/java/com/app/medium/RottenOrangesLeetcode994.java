package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 31/03/22
 * @project ds-algo-2021
 */
public class RottenOrangesLeetcode994 {
    static int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};

    private static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int time = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] rem = q.poll();

                for(int j = 0; j < directions.length; j++) {
                    int newRow = rem[0] + directions[j][0];
                    int newCol = rem[1] + directions[j][1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] != 1)
                        continue;

                    grid[newRow][newCol] = 2;
                    q.add(new int[]{newRow, newCol});
                }
            }
            time++;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return time == -1 ? 0: time;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = orangesRotting(grid);

        System.out.println(ans);
    }
}
