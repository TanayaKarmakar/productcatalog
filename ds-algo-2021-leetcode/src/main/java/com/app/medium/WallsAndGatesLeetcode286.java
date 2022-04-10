package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 03/04/22
 * @project ds-algo-2021
 */
public class WallsAndGatesLeetcode286 {
    private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();

        int m = rooms.length;
        int n = rooms[0].length;

        boolean[][] visited = new boolean[m][n];

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
                int[] rem = q.poll();
                visited[rem[0]][rem[1]] = true;

                for(int j = 0; j < directions.length; j++) {
                    int newRow = rem[0] + directions[j][0];
                    int newCol = rem[1] + directions[j][1];
                    if(newRow < 0 || newRow >=m || newCol < 0 || newCol >= n
                    || visited[newRow][newCol] || rooms[newRow][newCol] == 0 || rooms[newRow][newCol] == -1)
                        continue;
                    rooms[newRow][newCol] = (rooms[rem[0]][rem[1]] == -1? 1: Integer.min(rooms[rem[0]][rem[1]] + 1, rooms[newRow][newCol]));
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};

        wallsAndGates(rooms);

        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}
