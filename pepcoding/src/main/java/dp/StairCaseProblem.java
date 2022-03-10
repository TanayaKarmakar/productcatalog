package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 08/03/22
 * @project ds-algo-2021
 */
public class StairCaseProblem {
    private static int totalWays(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        steps[2] = 2;
        for(int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
        }
        return steps[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int ans = totalWays(n);

        System.out.println(ans);
        scanner.close();
    }
}
