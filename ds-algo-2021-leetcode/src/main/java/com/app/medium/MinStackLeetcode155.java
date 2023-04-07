package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */

class MinStack {
  Stack<Integer> stack;
  Stack<Integer> minimum;

  public MinStack() {
    stack = new Stack<>();
    minimum = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    if(minimum.isEmpty() || minimum.peek() > val)
      minimum.push(val);
  }

  public void pop() {
    int value = stack.pop();
    if(value == minimum.peek())
      minimum.pop();
  }

  public int top() {
    return stack.isEmpty() ? -1: stack.peek();
  }

  public int getMin() {
    return minimum.isEmpty() ? -1: minimum.peek();
  }
}

public class MinStackLeetcode155 {
  public static void main(String[] args) {

  }
}
