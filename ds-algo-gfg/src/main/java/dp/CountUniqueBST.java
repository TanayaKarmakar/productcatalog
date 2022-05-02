package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 30/04/22
 * @project ds-algo-2021
 */
public class CountUniqueBST {
    private static int count(int n) {
        if(n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j -1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = count(n);

        System.out.println(ans);

        scanner.close();
    }
}
