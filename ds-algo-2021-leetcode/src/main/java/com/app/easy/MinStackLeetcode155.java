package com.app.easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        int val = stack.pop();
        if(!minStack.isEmpty() && minStack.peek() == val)
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minStack.isEmpty() ? 0: minStack.peek();
    }
}



public class MinStackLeetcode155 {
    public static void main(String[] args) {

    }
}
