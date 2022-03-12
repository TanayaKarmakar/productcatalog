package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/03/22
 * @project ds-algo-2021
 */
public class ArrangeBuildings {
    private static long countTotal(int n) {
        int prevB = 1;
        int prevS = 1;

        for(int i = 2; i <= n; i++) {
            int currB = prevS;
            int currS = prevS + prevB;
            prevS = currS;
            prevB = currB;
        }
        return (prevB + prevS) * (prevB + prevS);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = countTotal(n);

        System.out.println(ans);

    }
}
