package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 24/03/22
 * @project ds-algo-2021
 */
public class DecodeStringLeetcode394 {
    private static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); ) {
            int num = 0;
            char ch = s.charAt(i);
            while(Character.isDigit(ch)) {
                i++;
                num = num * 10 + (ch - '0');
                ch = s.charAt(i);
            }
            if(num != 0)
                numStack.push(num);
            if(ch == ']') {
                String str = "";
                while(!charStack.isEmpty() && !charStack.peek().equals("[")) {
                    str = charStack.pop() + str;
                }
                charStack.pop();
                if(!numStack.isEmpty()) {
                    num = numStack.pop();
                }
                sb = new StringBuilder();
                if(num != 0) {
                    while(num-- > 0) {
                        sb.append(str);
                    }
                }
                charStack.push(sb.toString());

            } else {
                charStack.push(ch + "");
            }
            i++;
        }
        sb = new StringBuilder();
        while(!charStack.isEmpty()) {
            sb.insert(0, charStack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "3[a2[c]]";

        String ans = decodeString(str);

        System.out.println(ans);
    }
}
