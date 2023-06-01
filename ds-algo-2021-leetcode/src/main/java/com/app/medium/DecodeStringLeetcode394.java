package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */
public class DecodeStringLeetcode394 {
  private static String decodeString(String s) {
    Stack<String> textStack = new Stack<>();
    Stack<Integer> digitStack = new Stack<>();
    int n = s.length();
    int digit = 0;
    StringBuilder sb = null;
    for(int i = 0; i < n;) {
      if(Character.isDigit(s.charAt(i))) {
        digit = 0;
        while(i < n && Character.isDigit(s.charAt(i))) {
          digit = digit * 10 + (s.charAt(i) - '0');
          i++;
        }
        digitStack.push(digit);
      }

      else if(s.charAt(i) == ']') {
        sb = new StringBuilder();
        while(!textStack.isEmpty() && !textStack.peek().equals("[")) {
          sb.insert(0, textStack.pop());
        }
        textStack.pop();
        String str = sb.toString();
        sb = new StringBuilder();
        digit = digitStack.pop();
        while(digit-- > 0) {
          sb.append(str);
        }
        textStack.push(sb.toString());
        i++;
      } else {
        textStack.push(s.charAt(i) + "");
        i++;
      }
    }

    sb = new StringBuilder();
    while(!textStack.isEmpty()) {
      sb.insert(0, textStack.pop());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(decodeString("3[a]2[bc]"));
    System.out.println(decodeString("3[a2[c]]"));
  }
}
