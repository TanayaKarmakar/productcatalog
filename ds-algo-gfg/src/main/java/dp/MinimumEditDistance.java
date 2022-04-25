package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class MinimumEditDistance {
    private static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int option1 = dp[i - 1][j];
                    int option2 = dp[i][j - 1];
                    int option3 = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Integer.min(option1, Integer.min(option2, option3));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int ans = editDistance(s1, s2);

        System.out.println(ans);

        scanner.close();
    }
}
