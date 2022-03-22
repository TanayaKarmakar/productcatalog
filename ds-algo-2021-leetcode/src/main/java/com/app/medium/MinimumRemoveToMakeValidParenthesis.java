package com.app.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class MinimumRemoveToMakeValidParenthesis {
    private static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indicesExcluded = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty())
                    indicesExcluded.add(i);
                else
                    stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            indicesExcluded.add(stack.pop());
           // stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!indicesExcluded.contains(i))
               sb.append(s.charAt(i) + "");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "lee(t(c)o)de)";

        String result = minRemoveToMakeValid(str);

        System.out.println(result);
    }
}
