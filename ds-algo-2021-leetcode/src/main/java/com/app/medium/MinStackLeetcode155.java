package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */

class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    if(minStack.isEmpty() || val <= minStack.peek())
      minStack.push(val);
  }

  public void pop() {
    int val = stack.pop();
    if(minStack.peek() == val)
      minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.isEmpty() ? 0:minStack.peek();
  }
}

public class MinStackLeetcode155 {
  public static void main(String[] args) {

  }
}
