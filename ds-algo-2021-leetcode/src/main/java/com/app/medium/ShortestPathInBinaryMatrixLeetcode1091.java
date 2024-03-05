package com.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInBinaryMatrixLeetcode1091 {
    private static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        int n = grid.length;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{1,-1},{-1,-1},{1,1}};

        Set<String> visited = new HashSet<>();

        int count = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited.add("0:0");

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if(curr[0] == n - 1 && curr[1] == n - 1)
                    return count;
                for(int j = 0; j < directions.length; j++) {
                    int newRow = curr[0] + directions[j][0];
                    int newCol = curr[1] + directions[j][1];
                    if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= n
                            || visited.contains(newRow+":"+newCol) || grid[newRow][newCol] == 1)
                        continue;
                    queue.add(new int[]{newRow, newCol});
                    visited.add(newRow+":"+newCol);
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
