package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesLeetcode286 {
    private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();

        int m = rooms.length;
        int n = rooms[0].length;

        for(int i = 0; i < m; i++) {
            for(int j= 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }


        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i = 0; i < directions.length; i++) {
                int newRow = current[0] + directions[i][0];
                int newCol = current[1] + directions[i][1];

                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || rooms[newRow][newCol] == -1)
                    continue;

                int newDistance = rooms[current[0]][current[1]] + 1;
                if(newDistance < rooms[newRow][newCol]) {
                    rooms[newRow][newCol] = newDistance;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
