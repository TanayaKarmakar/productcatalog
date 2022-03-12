package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/03/22
 * @project ds-algo-2021
 */
public class CountOfBinaryStrings {
    private static int countConstantSpace(int n) {
        int prevZeros = 1;
        int prevOnes = 1;

        for(int i = 2; i <= n; i++) {
            int currZeros = prevOnes;
            int currOnes = prevOnes + prevZeros;
            prevOnes = currOnes;
            prevZeros = currZeros;
        }

        return prevOnes + prevZeros;
    }

    private static int count(int n) {
        int[] dpz = new int[n + 1];
        int[] dpo = new int[n + 1];

        dpz[1] = 1;
        dpo[1] = 1;

        for(int i = 2; i <= n; i++) {
            dpo[i] = dpz[i - 1] + dpo[i - 1];
            dpz[i] = dpo[i - 1];
        }

        return dpo[n] + dpz[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = count(n);

        System.out.println("Array approach - " + ans);

        ans = countConstantSpace(n);

        System.out.println("Constant space approach - " + ans);
    }
}
