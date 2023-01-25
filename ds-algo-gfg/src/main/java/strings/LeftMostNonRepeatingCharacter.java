package strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 10/05/22
 * @project ds-algo-2021
 */
public class LeftMostNonRepeatingCharacter {
    private static int leftMostIndxApproach2(String str) {
        int[] charIndx = new int[256];
        Arrays.fill(charIndx, -1);

        for(int i = 0; i < str.length(); i++) {
            if(charIndx[str.charAt(i)] == -1) {
                charIndx[str.charAt(i)] = i;
            } else {
                charIndx[str.charAt(i)] = -2;
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 256; i++) {
            if(charIndx[i] >= 0)
                res = Integer.min(res, charIndx[i]);
        }
        return res;
    }

    private static int leftMostIndx(String str) {
        boolean[] visited = new boolean[256];
        int res = -1;

        for(int i = str.length() - 1; i >= 0; i--) {
            if(!visited[str.charAt(i)]) {
                res = i;
                visited[str.charAt(i)] = true;
            } else {
                res = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        System.out.println(leftMostIndx(str));

        System.out.println(leftMostIndxApproach2(str));

        scanner.close();
    }
}
