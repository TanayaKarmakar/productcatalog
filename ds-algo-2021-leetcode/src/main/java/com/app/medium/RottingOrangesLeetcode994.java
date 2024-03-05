package com.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottingOrangesLeetcode994 {
    private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        Set<String> visited = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited.add(i + ":" + j);
                }
            }
        }

        int count = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0 ; j < size; j++) {
                int[] curr = queue.poll();

                for(int i = 0; i < directions.length; i++) {
                    int newRow = curr[0] + directions[i][0];
                    int newCol = curr[1] + directions[i][1];

                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
                            || grid[newRow][newCol] == 0 || visited.contains(newRow + ":" + newCol))
                        continue;

                    grid[newRow][newCol] = 2;
                    queue.add(new int[]{newRow, newCol});
                    visited.add(newRow + ":" + newCol);
                }
            }
            count++;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return count == -1 ? 0: count;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = orangesRotting(grid);

        System.out.println(ans);
    }
}
