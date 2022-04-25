package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class MaximumCut {
    private static int maxCutTabulation(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int option1 = 0;
            if(i >= a)
                option1 = dp[i - a];
            int option2 = 0;
            if(i >= b)
                option2 = dp[i - b];
            int option3 = 0;
            if(i >= c)
                option3 = dp[i - c];
            dp[i] = 1 + Integer.max(option1, Integer.max(option2, option3));
        }
        return dp[n];
    }

    private static int maxCutRec(int n, int a, int b, int c) {
        if(n == 0)
            return 0;
        if(n < 0)
            return Integer.MIN_VALUE;
        int option1 = maxCutRec(n - a, a, b, c);
        int option2 = maxCutRec(n - b, a, b, c);
        int option3 = maxCutRec(n - c, a, b, c);
        return 1 + Integer.max(option1, Integer.max(option2, option3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int ans = maxCutRec(n, a, b, c);
        System.out.println("Recursion - " + ans);

        ans = maxCutTabulation(n, a, b, c);
        System.out.println("Tabulation - " + ans);

        scanner.close();
    }
}
