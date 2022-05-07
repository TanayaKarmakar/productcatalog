package com.app.medium;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class LongestLineWithConsecutiveOnesLeetcode562 {
    private static int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dpH = new int[m][n];
        int[][] dpV = new int[m][n];
        int[][] dpD = new int[m][n];
        int[][] dpAD = new int[m][n];

        int maxVal = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    dpH[i][j] = (j == 0 ? mat[i][j] : 1 + dpH[i][j - 1]);
                }
                maxVal = Integer.max(maxVal, dpH[i][j]);
            }
        }

        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                if(mat[i][j] == 1)
                    dpV[i][j] = (i == 0 ? mat[i][j] : 1 + dpV[i - 1][j]);
                maxVal = Integer.max(maxVal, dpV[i][j]);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    dpD[i][j] = ((i > 0 && j > 0) ? 1 + dpD[i - 1][j - 1]: mat[i][j]);
                }
                maxVal = Integer.max(maxVal, dpD[i][j]);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(mat[i][j] == 1) {
                    dpAD[i][j] = ((j + 1 < n && i > 0) ? 1 + dpAD[i - 1][j + 1]: mat[i][j]);
                }
                maxVal = Integer.max(maxVal, dpAD[i][j]);
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};

        int ans = longestLine(matrix);

        System.out.println(ans);
    }
}
