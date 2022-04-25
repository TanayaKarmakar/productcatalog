package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class LongestRepeatingSubsequence {
    private static int longestRepeatingSubseq(String s1) {
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s1.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();

        int ans = longestRepeatingSubseq(s1);

        System.out.println(ans);

        scanner.close();
    }
}
