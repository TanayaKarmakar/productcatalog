package recursion;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class PowerLogarithmic {
    private static int power(int x, int n) {
        if(n == 0)
            return 1;
        int smallerValue = power(x, n / 2);
        int value = smallerValue * smallerValue;
        if(n % 2 != 0) {
            value = x * value;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int ans = power(x, n);
        System.out.println("Ans - " + ans);
        scanner.close();
    }
}
