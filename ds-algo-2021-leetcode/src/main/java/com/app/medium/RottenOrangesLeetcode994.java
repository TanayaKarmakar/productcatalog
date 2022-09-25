package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class RottenOrangesLeetcode994 {
    private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //boolean[][] visited = new boolean[m][n];
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
                int[] curr = q.poll();
                for(int j = 0; j < directions.length; j++) {
                    int newRow = curr[0] + directions[j][0];
                    int newCol = curr[1] + directions[j][1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
                    || grid[newRow][newCol] != 1)
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
        return time;
    }


    public static void main(String[] args) {

    }
}
