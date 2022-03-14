package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 14/03/22
 * @project ds-algo-2021
 */
public class TilingWithDominosMX1 {
    private static int totalWays(int n, int m) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(i < m) {
                dp[i] = 1;
            } else if(i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int ans = totalWays(n, m);
        System.out.println(ans);

        scanner.close();
    }
}
