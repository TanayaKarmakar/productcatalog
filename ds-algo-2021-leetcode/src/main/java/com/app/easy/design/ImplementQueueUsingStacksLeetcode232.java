package com.app.easy.design;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack1.push(x);

        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        if(stack2.isEmpty())
            return -1;
        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty())
            return -1;
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }
}


public class ImplementQueueUsingStacksLeetcode232 {
    public static void main(String[] args) {

    }
}
