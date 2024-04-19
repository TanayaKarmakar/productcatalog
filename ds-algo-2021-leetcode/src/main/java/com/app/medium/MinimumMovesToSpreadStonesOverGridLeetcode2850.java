package com.app.medium;

import java.util.*;

public class MinimumMovesToSpreadStonesOverGridLeetcode2850 {
    private static int minimumMoves(int[][] grid) {
        Queue<int[][]> queue = new LinkedList<>();

        queue.add(grid);
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.deepToString(grid));
        int count = 0;
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[][] remGrid = queue.poll();
                if(isValid(remGrid))
                    return count;

                for(int i1 = 0; i1 < 3; i1++) {
                    for(int j1 = 0; j1 < 3; j1++) {
                        if(remGrid[i1][j1] > 1) {
                            for(int[] curr: dir) {
                                int newI = i1 + curr[0];
                                int newJ = j1 + curr[1];
                                if(newI >= 0 && newI < 3 && newJ >= 0 && newJ < 3) {
                                    int[][] cloneGrid = deepCopy(remGrid);
                                    cloneGrid[i1][j1]--;
                                    cloneGrid[newI][newJ]++;
                                    String key = Arrays.deepToString(cloneGrid);
                                    if(!visited.contains(key)) {
                                        visited.add(key);
                                        queue.add(cloneGrid);
                                    }
                                }
                            }
                        }
                    }
                }

            }
            count++;
        }

        return -1;
    }

    private static int[][] deepCopy(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }

    private static boolean isValid(int[][] grid) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{1,1,1},{1,2,1}};
        int ans = minimumMoves(grid);

        System.out.println(ans);
    }
}
