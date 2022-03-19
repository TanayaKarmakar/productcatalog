package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 14/03/22
 * @project ds-algo-2021
 */
public class FriendsPairing {
    private static int totalWays(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int ans = totalWays(n);

        System.out.println(ans);

        scanner.close();
    }
}
