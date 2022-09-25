package com.app.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class WallsAndGateLeetcode286 {
    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int j = 0; j < directions.length; j++) {
                    int newRow = curr[0] + directions[j][0];
                    int newCol = curr[1] + directions[j][1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
                    || rooms[newRow][newCol] == -1 || rooms[newRow][newCol] == 0)
                        continue;
                    int newDistance = 1 + rooms[curr[0]][curr[1]];
                    if(rooms[newRow][newCol] > newDistance) {
                        rooms[newRow][newCol] = newDistance;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }

    //[[2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647]]

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647}};

        wallsAndGates(rooms);

        for(int i = 0; i < rooms.length; i++) {
            System.out.println(Arrays.toString(rooms[i]));
        }
    }
}
