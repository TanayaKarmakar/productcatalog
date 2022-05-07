package com.app.medium;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class ValidSubstitutionLeetcode1003 {
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'c') {
                if(stack.isEmpty() || stack.size() < 2)
                    return false;
                else {
                    char ch2 = stack.pop();
                    char ch1 = stack.pop();
                    if(ch1 != 'a' || ch2 != 'b')
                        return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        boolean isValid = isValid(str);

        System.out.println(isValid);

        scanner.close();
    }
}
