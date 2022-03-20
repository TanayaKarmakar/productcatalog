package recursion;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class Power {
    private static int power(int x, int n) {
        if(n == 0)
            return 1;
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        int ans = power(x, n);

        System.out.println(ans);

    }
}
