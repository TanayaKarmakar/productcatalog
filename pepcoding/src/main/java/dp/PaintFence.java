package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 14/03/22
 * @project ds-algo-2021
 */
public class PaintFence {
    private static int totalWays(int n, int k) {
        int same = k;
        int diff = k * (k - 1);

        int total = same + diff;
        for(int i = 3; i <= n; i++) {
            int nSame = diff;
            int nDiff = total * (k - 1);
            int nTotal = nSame + nDiff;
            same = nSame;
            diff = nDiff;
            total = nTotal;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = totalWays(n, k);
        System.out.println("TotalWays - " + ans);
        scanner.close();
    }
}
