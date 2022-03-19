package com.app.easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class RemoveAdjacentDuplicateLeetcode1047 {
    private static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() || s.charAt(i) != stack.peek()) {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == stack.peek()) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abbaca";

        System.out.println(removeDuplicates(str));
    }
}
