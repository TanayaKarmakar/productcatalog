package com.app.easy;

import java.util.Iterator;
import java.util.Stack;

public class RemoveAdjacentDuplicatesInStringLeetcode1047 {
    private static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        Iterator<Character> sItr = stack.iterator();
        StringBuilder sb = new StringBuilder();
        while(sItr.hasNext()) {
            sb.append(sItr.next());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
