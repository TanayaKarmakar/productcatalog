package com.app.medium.design;


import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || min.peek() >= val)
            min.push(val);
    }

    public void pop() {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            if(!min.isEmpty() && min.peek() == val) {
                min.pop();
            }
        }
    }

    public int top() {
        if(stack.isEmpty())
            return Integer.MAX_VALUE;
        return stack.peek();
    }

    public int getMin() {
        if(min.isEmpty())
            return Integer.MAX_VALUE;
        return min.peek();
    }
}
public class MinStackLeetcode155 {
    public static void main(String[] args) {

    }
}
