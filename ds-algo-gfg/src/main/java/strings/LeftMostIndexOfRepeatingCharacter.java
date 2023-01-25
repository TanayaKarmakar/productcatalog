package strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 10/05/22
 * @project ds-algo-2021
 */
public class LeftMostIndexOfRepeatingCharacter {
    private static int leftMostIndxApproach2(String str) {
        boolean[] visited = new boolean[256];

        int res = -1;
        for(int i = str.length() - 1; i >= 0; i--) {
            if(visited[str.charAt(i)])
                res = i;
            else
                visited[str.charAt(i)] = true;
        }
        return res;
    }


    private static int leftMostIndx(String str) {
        int[] charIndx = new int[256];
        Arrays.fill(charIndx, -1);

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < str.length(); i++) {
            int fi = charIndx[str.charAt(i)];
            if(fi == -1)
                charIndx[str.charAt(i)] = i;
            else
                res = Integer.min(res, fi);
        }

        return res == Integer.MAX_VALUE ? -1: res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int indx = leftMostIndx(str);

        System.out.println("Approach1 - " + indx);

        indx = leftMostIndxApproach2(str);

        System.out.println("Approach2 - " + indx);

        scanner.close();
    }
}
