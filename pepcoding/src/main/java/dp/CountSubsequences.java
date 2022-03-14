package dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 13/03/22
 * @project ds-algo-2021
 */
public class CountSubsequences {
    private static int countSubsequences(String str) {
        int a = 0;
        int ab = 0;
        int abc = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a') {
                a = 2 * a + 1;
            } else if(ch == 'b') {
                ab = 2 * ab + a;
            } else if(ch == 'c') {
                abc = 2 * abc + ab;
            }
        }
        return abc;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int ans = countSubsequences(str);

        System.out.println(ans);
        scanner.close();
    }
}
