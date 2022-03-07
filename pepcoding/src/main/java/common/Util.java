package common;

/**
 * @author t0k02w6 on 05/03/22
 * @project ds-algo-2021
 */
public class Util {
    public static int factorial(int n) {
        if(n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
