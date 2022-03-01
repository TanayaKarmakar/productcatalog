package easy;

/**
 * @author t0k02w6 on 08/02/22
 * @project ds-algo-2021
 */
public class PalindromeNumberLeetcode09 {
    private static boolean isPalindrome(int x) {
        if(x < 0 || x == Integer.MAX_VALUE)
            return false;

        long tmp = x;
        long result = 0;
        while(tmp != 0) {
            long r = tmp % 10;
            result = result * 10 + r;
            if((result * 10) >= Integer.MAX_VALUE)
                break;
            tmp = tmp / 10;
        }

        return result == x;
    }
}
