package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/03/22
 * @project ds-algo-2021
 */
public class DecodeWays {
    private static int totalWays(String s) {
        char[] arr = s.toCharArray();

        int countPrev = 1;
        int countPrevPrev = 1;
        for(int i = 1; i < arr.length; i++) {
            int d = arr[i] - '0';
            int dd = (arr[i - 1] - '0') * 10 + d;
            int count = 0;
            if(d > 0) {
                count += countPrev;
            }
            if(dd >= 10 && dd <= 26) {
                count += countPrevPrev;
            }
            countPrevPrev = countPrev;
            countPrev = count;
        }
        return countPrev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int ans = totalWays(str);
        System.out.println(ans);

        scanner.close();
    }
}
