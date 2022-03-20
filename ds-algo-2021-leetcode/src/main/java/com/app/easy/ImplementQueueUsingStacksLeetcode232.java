package com.app.easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
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

        stack2.push(x);

        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
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
