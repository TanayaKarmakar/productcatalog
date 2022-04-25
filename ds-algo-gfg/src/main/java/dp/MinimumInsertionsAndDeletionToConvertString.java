package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class MinimumInsertionsAndDeletionToConvertString {
    private static int minInsertDelete(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return (m - dp[m][n]) + (n - dp[m][n]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int ans = minInsertDelete(s1, s2);

        System.out.println("Minimum Insertion and Deletion - " + ans);

        scanner.close();
    }
}
