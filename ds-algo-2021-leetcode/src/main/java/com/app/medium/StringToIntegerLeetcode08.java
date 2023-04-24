package com.app.medium;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class StringToIntegerLeetcode08 {
  private static boolean isDigit(String token) {
    try {
      Long.parseLong(token);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  private static int myAtoi(String s) {
    s = s.trim();
    s = s.split("\\s+")[0];

   if(!isDigit(s))
     return 0;

    char ch = s.charAt(0);
    boolean isNeg = false;
    if(ch == '+' || ch == '-') {
      s = s.substring(1);
      if(ch == '-')
        isNeg = true;
    }

    long temp = 0;
    boolean isOverFlow = false;
    for(int i = 0; i < s.length(); i++) {
      int currentDigit = s.charAt(i) - '0';
      if((temp * 10 + currentDigit) >= Integer.MAX_VALUE) {
        isOverFlow = true;
        break;
      }
      temp = temp * 10 + currentDigit;
    }

    if(!isOverFlow) {
      if(isNeg) {
        temp = -temp;
      }
      return (int)temp;
    }
    if(isNeg)
      return Integer.MIN_VALUE;
    return Integer.MAX_VALUE;
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("words and 987"));
  }
}
