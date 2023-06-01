package com.app.onlinetest.nextthink;

/**
 * @author t0k02w6 on 27/05/23
 * @project ds-algo-2021-leetcode
 */
public class DeleteDigitAndGetMaximum {
  private static int solution(int N) {
    // Implement your solution here
    String str = String.valueOf(N);
    boolean isNeg = false;
    if(str.charAt(0) == '-') {
      isNeg = true;
      str = str.substring(1);
    }

    int max = Integer.MIN_VALUE;

    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String left = null;
      String right = null;
      if(ch == '5') {
        if(i == 0) {
          left = "";
          right = str.substring(i + 1);
        } else if(i == str.length() - 1) {
          right = "";
          left = str.substring(0, i);
        } else {
          left = str.substring(0, i);
          right = str.substring(i + 1);
        }
        String newDigit = left + right;
        int digit = Integer.parseInt(newDigit);
        if(isNeg) {
          digit = -digit;
        }
        max = Integer.max(digit, max);
      }
    }


    //System.out.println(str);
    return max;
  }

  public static void main(String[] args) {
    int n = -5859;
    System.out.println(solution(n));
    System.out.println(solution(15958));
    System.out.println(solution(-5000));
  }
}
