package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 31/10/21
 * @project ds-algo-2021
 */
public class UniquePathsLeetcode62 {
    private static int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        for(int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int ans = uniquePaths(m, n);
        System.out.println(ans);

        scanner.close();
    }
}
