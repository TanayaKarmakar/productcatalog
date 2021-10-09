package com.app.medium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @author t0k02w6 on 06/10/21
 * @project ds-algo-2021
 */
public class MinimumRemoveToMakeValidParenthesisLeetcode1249 {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> itemsToBeRemoved = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(s.charAt(i) == ')') {
                if(stack.isEmpty())
                    itemsToBeRemoved.add(i);
                else
                    stack.pop();
            }
        }

        while(!stack.isEmpty())
            itemsToBeRemoved.add(stack.pop());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!itemsToBeRemoved.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(minRemoveToMakeValid(str));

        scanner.close();
    }
}
