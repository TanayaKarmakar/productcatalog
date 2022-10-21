package com.app.medium;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class StringToIntegerLeetcode08 {
  private static int myAtoi(String s) {
    if(s == null || s.isEmpty())
      return 0;
    s = s.trim();
    String[] tokens = s.split("\\s+");
    s = tokens[0];
    if(s.isEmpty())
      return 0;
    boolean isNeg = false;
    if(s.charAt(0) == '-' || s.charAt(0) == '+') {
      if(s.charAt(0) == '-')
        isNeg = true;
      s = s.substring(1);
    }

    long result = 0;
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(Character.isDigit(ch)) {
        result = result * 10 + (ch - '0');
        if(result >= Integer.MAX_VALUE)
          break;
      } else
        break;
    }

    if(isNeg) {
      result = -result;
    }
    if(result >= Integer.MAX_VALUE)
      result = Integer.MAX_VALUE;
    if(result < Integer.MIN_VALUE)
      result = Integer.MIN_VALUE;
    return (int)result;
  }

  public static void main(String[] args) {

  }
}
