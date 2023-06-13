package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class EvaluateReversePolishNotationLeetcode150 {
  private static int evalRPN(String[] tokens) {
    Stack<Integer> numStack = new Stack<>();
    for(int i = 0; i < tokens.length; i++) {
      if(isDigit(tokens[i])) {
        numStack.push(Integer.parseInt(tokens[i]));
      } else {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        int result = performOperation(num1, num2, tokens[i]);
        numStack.push(result);
      }
    }
    return numStack.peek();
  }

  private static int performOperation(int num1, int num2, String token) {
    switch (token) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      case "*":
        return num1 * num2;
      case "/":
        return num1 / num2;
      default:
        throw new RuntimeException("Invalid Operation");
    }
  }

  private static boolean isDigit(String token) {
    try {
      int val = Integer.parseInt(token);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  public static void main(String[] args) {

  }
}
