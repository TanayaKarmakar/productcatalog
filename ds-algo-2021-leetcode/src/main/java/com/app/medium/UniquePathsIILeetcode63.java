package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 31/10/21
 * @project ds-algo-2021
 */
public class UniquePathsIILeetcode63 {
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];

        paths[0][0] = 1;
        for(int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 0) {
                paths[i][0] = paths[i - 1][0];
            }
        }

        for(int i = 1; i < n; i++) {
            if(obstacleGrid[0][i] == 0) {
                paths[0][i] = paths[0][i - 1];
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    continue;
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstracleGrid = {{1, 0}};

        int ans = uniquePathsWithObstacles(obstracleGrid);

        System.out.println(ans);

    }
}
