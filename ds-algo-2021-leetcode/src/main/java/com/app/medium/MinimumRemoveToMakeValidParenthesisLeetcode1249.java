package com.app.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class MinimumRemoveToMakeValidParenthesisLeetcode1249 {
    private static String minRemoveToMakeValid(String s) {
        Set<Integer> removedIndexSet = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    removedIndexSet.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            removedIndexSet.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == ')') {
                if(!removedIndexSet.contains(i)) {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
