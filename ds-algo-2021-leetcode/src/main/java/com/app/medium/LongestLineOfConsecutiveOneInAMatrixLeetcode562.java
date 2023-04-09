package com.app.medium;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestLineOfConsecutiveOneInAMatrixLeetcode562 {
  private static int longestLine(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    int[][] dpH = new int[m][n];
    int[][] dpV = new int[m][n];
    int[][] dpD = new int[m][n];
    int[][] dpAD = new int[m][n];

    populateHorizontal(mat, dpH, m, n);
    populateVertical(mat, dpV, m, n);
    populateDiag(mat, dpD, m, n);
    populateAntiDiag(mat, dpAD, m, n);


    int maxValue = 0;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int option1 = Integer.max(dpH[i][j], dpV[i][j]);
        int option2 = Integer.max(dpD[i][j], dpAD[i][j]);
        maxValue = Integer.max(option1, option2);
      }
    }
    return maxValue;
  }

  private static void populateAntiDiag(int[][] mat, int[][] dp, int m, int n) {
    for(int i = n - 1; i >= 0; i--) {
      dp[0][i] = mat[0][i];
    }

    for(int i = 1; i < m; i++) {
      dp[i][n - 1] = mat[i][n - 1];
    }

    for(int i = 1; i < m; i++) {
      for(int j = n - 2; j >= 0; j--) {
        if(mat[i][j] == 1) {
          dp[i][j] = 1 + dp[i - 1][j + 1];
        }
      }
    }
  }

  private static void populateDiag(int[][] mat, int[][] dp, int m, int n) {
    for(int i = 0; i < n; i++) {
      dp[0][i] = mat[0][i];
    }

    for(int i = 0; i < m; i++) {
      dp[i][0] = mat[i][0];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(mat[i][j] == 1) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        }
      }
    }

  }

  private static void populateVertical(int[][] mat, int[][] dp, int m, int n) {
    for(int i = 0; i < n; i++) {
      dp[0][i] = mat[0][i];
    }

    for(int j = 0; j < n; j++) {
      for(int i = 1; i < m; i++) {
        if(mat[i][j] == 1) {
          dp[i][j] = 1 + dp[i - 1][j];
        }
      }
    }
  }

  private static void populateHorizontal(int[][] mat, int[][] dp, int m, int n) {
    for(int i = 0; i < m; i++) {
      dp[i][0] = mat[i][0];
    }

    for(int i = 0; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(mat[i][j] == 1) {
          dp[i][j] = 1 + dp[i][j - 1];
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] mat = {{1,1,1,1},{0,1,1,0},{0,0,0,1}};

    int ans = longestLine(mat);

    System.out.println(ans);
  }
}
