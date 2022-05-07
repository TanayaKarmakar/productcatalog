package com.app.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class FindPermutationLeetcode484 {
    private static int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++) {
            stack.push(i + 1);
            if(i == n || s.charAt(i) == 'I') {
                while(!stack.isEmpty())
                    res[j++] = stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] rs = findPermutation(str);

        System.out.println(Arrays.toString(rs));

        scanner.close();
    }
}
