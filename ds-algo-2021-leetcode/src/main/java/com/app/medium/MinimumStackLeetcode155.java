package com.app.medium;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author t0k02w6 on 15/06/23
 * @project ds-algo-2021-leetcode
 */
class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> min;

  public MinStack() {
    stack = new Stack<>();
    min = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    if(min.isEmpty() || val <= min.peek())
      min.push(val);
  }

  public void pop() {
    if(stack.isEmpty())
      return;
    int val = stack.pop();
    if(min.peek() == val)
      min.pop();
  }

  public int top() {
    if(stack.isEmpty())
      return 0;
    return stack.peek();
  }

  public int getMin() {
    if(min.isEmpty())
      return 0;
    return min.peek();
  }
}

public class MinimumStackLeetcode155 {
  public static void main(String[] args) {

  }
}
