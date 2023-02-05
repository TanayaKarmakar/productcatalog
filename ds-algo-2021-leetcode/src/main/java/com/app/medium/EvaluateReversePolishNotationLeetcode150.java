package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 04/02/23
 * @project ds-algo-2021
 */
public class EvaluateReversePolishNotationLeetcode150 {
  private static boolean isDigit(String str) {
    try {
      int num = Integer.parseInt(str);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  private static int evalRPN(String[] tokens) {
    Stack<Integer> numStack = new Stack<>();

    for(String token: tokens) {
      if(isDigit(token)) {
        numStack.push(Integer.parseInt(token));
      } else {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        int result = performOperation(num1, num2, token);
        numStack.push(result);
      }
    }
    return numStack.peek();
  }

  private static int performOperation(int num1, int num2, String token) {
    switch (token) {
      case "+": return num1 + num2;
      case "-": return num1 - num2;
      case "*": return num1 * num2;
      case "/": return num1 / num2;
    }
    return 0;
  }

  public static void main(String[] args) {

  }
}
