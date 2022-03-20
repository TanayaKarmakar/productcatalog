package com.app.easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class BackspaceStringCompareLeetcode844 {
    private static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#') {
                if(!sStack.isEmpty())
                    sStack.pop();
            } else {
                sStack.push(s.charAt(i));
            }
        }

        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == '#') {
                if(!tStack.isEmpty())
                    tStack.pop();
            } else {
                tStack.push(t.charAt(i));
            }
        }

        if(sStack.size() != tStack.size())
            return false;

        while(!sStack.isEmpty() && !tStack.isEmpty()) {
            if(sStack.peek() != tStack.peek())
                return false;
            sStack.pop();
            tStack.pop();
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
