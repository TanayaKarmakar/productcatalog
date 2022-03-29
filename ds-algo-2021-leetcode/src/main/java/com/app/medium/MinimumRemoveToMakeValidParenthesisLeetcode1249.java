package com.app.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
public class MinimumRemoveToMakeValidParenthesisLeetcode1249 {
    private static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> excludedIndices = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            //System.out.println(s.charAt(i));
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(s.charAt(i) == ')') {
                if(stack.isEmpty())
                    excludedIndices.add(i);
                else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            excludedIndices.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!excludedIndices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "))((";

        String ans = minRemoveToMakeValid(str);

        System.out.println(ans);
    }
}
