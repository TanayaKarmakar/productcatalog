package com.app.medium;

/**
 * @author t0k02w6 on 04/07/23
 * @project ds-algo-2021-leetcode
 */
public class LongestLineOfConsecutiveOnesLeetcode562 {
  private static int longestLine(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    int[][] dpH = new int[m][n];
    int[][] dpV = new int[m][n];
    int[][] dpD = new int[m][n];
    int[][] dpaD = new int[m][n];

    calculateHorizontal(mat, dpH);
    calculateVertical(mat, dpV);
    calculateDiagonal(mat, dpD);
    calculateAntiDiagonal(mat, dpaD);

    int maxSize = 0;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int currentMax = Integer.max(Integer.max(dpH[i][j], dpV[i][j]), Integer.max(dpD[i][j], dpaD[i][j]));
        maxSize = Integer.max(maxSize, currentMax);
      }
    }
    return maxSize;
  }

  private static void calculateAntiDiagonal(int[][] mat, int[][] dpaD) {
    int m = mat.length;
    int n = mat[0].length;
    for(int i = 0; i < n; i++) {
      dpaD[0][i] = mat[0][i];
    }

    for(int i = 1; i < m; i++) {
      dpaD[i][n - 1] = mat[i][n - 1];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 0; j < n - 1; j++) {
        if(mat[i][j] == 1) {
          dpaD[i][j] = 1 + dpaD[i - 1][j + 1];
        }
      }
    }
  }

  private static void calculateDiagonal(int[][] mat, int[][] dpD) {
    int m = mat.length;
    int n = mat[0].length;
    for(int i = 0; i < n; i++) {
      dpD[0][i] = mat[0][i];
    }
    for(int i = 0; i < m; i++) {
      dpD[i][0] = mat[i][0];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(mat[i][j] == 1) {
          dpD[i][j] = 1 + dpD[i - 1][j - 1];
        }
      }
    }
  }

  private static void calculateVertical(int[][] mat, int[][] dpV) {
    int m = mat.length;
    int n = mat[0].length;
    for(int i = 0; i < n; i++) {
      dpV[0][i] = mat[0][i];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(mat[i][j] == 1) {
          dpV[i][j] = 1 + dpV[i - 1][j];
        }
      }
    }
  }

  private static void calculateHorizontal(int[][] mat, int[][] dpH) {
    int m = mat.length;
    int n = mat[0].length;
    for(int i = 0; i < m; i++) {
      dpH[i][0] = mat[i][0];
    }

    for(int i = 0; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(mat[i][j] == 1) {
          dpH[i][j] = 1 + dpH[i][j - 1];
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};

    int ans = longestLine(matrix);

    System.out.println(ans);
  }
}
