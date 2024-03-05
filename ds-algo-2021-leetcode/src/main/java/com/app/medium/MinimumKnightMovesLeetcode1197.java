package com.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMovesLeetcode1197 {
    private static int minKnightMoves(int x, int y) {
        int count = 0;
        int[][] directions = {{1,2},{2,1},{2,-1},{1,-2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        x = Math.abs(x);
        y = Math.abs(y);
        if(x == 1 && y == 1)
            return 2;

        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        visited.add("0:0");
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                if(point[0] == x && point[1] == y)
                    return count;

                for(int j = 0; j < directions.length; j++) {
                    int newX = point[0] + directions[j][0];
                    int newY = point[1] + directions[j][1];

                    if(newX < 0 || newX > 300 || newY < 0 || newY > 300)
                        continue;
                    if(!visited.contains(newX + ":" + newY)) {
                        visited.add(newX + ":" + newY);
                        q.add(new int[]{newX, newY});

                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minKnightMoves(2,1));
        System.out.println(minKnightMoves(1,1));
        System.out.println(minKnightMoves(5,5));
    }
}
