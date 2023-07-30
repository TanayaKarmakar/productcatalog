package com.app.medium.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author t0k02w6 on 29/07/23
 * @project ds-algo-2021-leetcode
 */

class MaxStack {
  static class StackItem {
    int item;
    int freq;

    public StackItem(int item, int freq) {
      this.item = item;
      this.freq = freq;
    }
  }

  Stack<Integer> stack;
  PriorityQueue<Integer> maxStack;
  Map<Integer, StackItem> map;

  public MaxStack() {
    stack = new Stack<>();
    maxStack = new PriorityQueue<>(Collections.reverseOrder());
    map = new HashMap<>();
  }

  public void push(int x) {
    stack.push(x);
    StackItem stackItem;
    if(!map.containsKey(x)) {
      stackItem = new StackItem(x, 1);
      maxStack.add(x);
    } else {
      stackItem = map.get(x);
      stackItem.freq += 1;
    }
    map.put(x, stackItem);
  }

  public int pop() {
    if(stack.isEmpty())
      return -1;
    int value = stack.pop();
    StackItem item = map.get(value);
    item.freq--;
    if(item.freq == 0) {
      List<Integer> tempList = new ArrayList<>();
      while(!maxStack.isEmpty() && maxStack.peek() != value) {
        tempList.add(maxStack.poll());
      }
      if(!maxStack.isEmpty()) {
        maxStack.poll();
      }
      maxStack.addAll(tempList);
    }

    return value;
  }

  public int top() {
    if(stack.isEmpty())
      return -1;
    return stack.peek();
  }

  public int peekMax() {
    if(maxStack.isEmpty())
      return stack.peek();
    return maxStack.peek();
  }

  public int popMax() {
    if(maxStack.isEmpty()) {
      return -1;
    }

    int value = maxStack.peek();
    StackItem stackItem = map.get(value);
    if(stackItem.freq == 1) {
      maxStack.poll();
      map.remove(value);
    } else {
      stackItem.freq--;
      map.put(value, stackItem);
    }
    Stack<Integer> tempStack = new Stack<>();
    while(!stack.isEmpty() && stack.peek() != value) {
      tempStack.push(stack.pop());
    }

    if(!stack.isEmpty())
      stack.pop();

    while(!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }
    return value;
  }
}

public class MaxStackLeetcode716 {
  public static void main(String[] args) {
    MaxStack maxStack = new MaxStack();

//    ["MaxStack","push","top","pop","push","push","popMax","popMax","push","popMax","push","push",
//    "pop","pop","push","popMax","push","push","push","push","peekMax"]
//
//    [[],[-44],[],[],[63],[-44],[],[],[-35],[],[57],[-88],[],[],[-45],[],[-34],[2],[-71],[0],[]]

    maxStack.push(-44);
    System.out.println(maxStack.top());
    System.out.println(maxStack.top());
    maxStack.push(63);
    maxStack.push(-44);
    System.out.println(maxStack.popMax());
    System.out.println(maxStack.popMax());
    maxStack.push(-35);
    System.out.println(maxStack.popMax());
    maxStack.push(57);
    maxStack.push(-88);
    System.out.println(maxStack.pop());
    System.out.println(maxStack.pop());
    maxStack.push(-45);
    System.out.println(maxStack.popMax());
    maxStack.push(-34);
    maxStack.push(2);
    maxStack.push(-71);
    maxStack.push(0);
    System.out.println(maxStack.peekMax());
//    maxStack.push(92);
//    System.out.println(maxStack.peekMax()); // 92
//    maxStack.push(54);
//    System.out.println(maxStack.peekMax()); // 92
//    maxStack.push(22);
//    System.out.println(maxStack.pop()); // 22
//    System.out.println(maxStack.pop()); // 54
//    maxStack.push(-57);
//    System.out.println(maxStack.peekMax()); // 92
//    maxStack.push(-24);
//    System.out.println(maxStack.popMax()); // 92
//    System.out.println(maxStack.top()); // -24
//    maxStack.push(26);
//    maxStack.push(-71);
//    System.out.println(maxStack.peekMax()); // 26
//    System.out.println(maxStack.popMax()); // 26
//    System.out.println(maxStack.popMax()); // -24

  }
}
