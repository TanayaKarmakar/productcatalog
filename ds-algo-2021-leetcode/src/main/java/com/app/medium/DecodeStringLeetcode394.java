package com.app.medium;

import java.util.Stack;

public class DecodeStringLeetcode394 {
    private static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        for(int i = 0; i < s.length(); ) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(num);
            }
            else if(s.charAt(i) == ']') {

                sb = new StringBuilder();
                while(!charStack.isEmpty() && !charStack.peek().equals("[")) {
                    sb.insert(0, charStack.pop());
                }
                charStack.pop();

                String str = sb.toString();
                sb = new StringBuilder();
                int number = numStack.pop();
                while(number-- > 0) {
                    sb.append(str);
                }
                charStack.push(sb.toString());
                i++;
            } else {
                charStack.push(s.charAt(i) + "");
                i++;
            }
        }
        sb = new StringBuilder();
        while(!charStack.isEmpty()) {
            sb.insert(0, charStack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("3[a2[c]]"));
    }
}
