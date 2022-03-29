package com.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
 */
public class MinimumKnightMoveLeetcode1197 {
    private static int[][] positions = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};

    private static int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x == 1 && y == 1)
            return 2;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        q.add(new int[]{0,0});

        Set<String> visited = new HashSet<>();
        visited.add("0:0");


        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] rem = q.poll();
                if(rem[0] == x && rem[1] == y)
                    return count;

                for(int[] postion: positions) {
                    int newX = rem[0] + postion[0];
                    int newY = rem[1] + postion[1];
                    if(newX < 0 || newX > 300 || newY < 0 || newY > 300)
                        continue;
                    String key = newX + ":" + newY;
                    if(!visited.contains(key)) {
                        visited.add(key);
                        q.add(new int[]{newX, newY});
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int ans = minKnightMoves(x, y);

        System.out.println(ans);
    }
}
