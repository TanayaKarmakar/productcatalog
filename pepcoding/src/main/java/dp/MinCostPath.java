package dp;

/**
 * @author t0k02w6 on 09/03/22
 * @project ds-algo-2021
 */
public class MinCostPath {
    private static int minCostPath(int[][] path) {
        int m = path.length;
        int n = path[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = path[i][j];
                } else if(i == 0) {
                    dp[i][j] = dp[i][j - 1] + path[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + path[i][j];
                } else {
                    dp[i][j] = path[i][j] + Integer.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] path = {{2,8,4,1,6,4,2},{6,0,9,5,3,8,5},{1,4,3,4,0,6,5},{6,4,7,2,4,6,1},{1,0,3,7,1,2,7},{1,5,3,2,3,0,9},{2,2,5,1,9,8,0}};
        int ans = minCostPath(path);

        System.out.println(ans);
    }
}
