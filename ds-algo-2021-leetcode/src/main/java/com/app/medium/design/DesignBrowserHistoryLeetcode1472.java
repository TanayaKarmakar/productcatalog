package com.app.medium.design;


import java.util.Stack;

class BrowserHistory {
    Stack<String> forward;
    Stack<String> backward;

    public BrowserHistory(String homepage) {
        forward = new Stack<>();
        backward = new Stack<>();
        forward.push(homepage);
    }

    public void visit(String url) {
        if(!backward.isEmpty()) {
            backward.clear();
        }
        forward.add(url);
    }

    public String back(int steps) {
        int maxStep = Integer.min(forward.size() - 1, steps);
        while(maxStep-- > 0) {
            backward.push(forward.pop());
        }
        return !forward.isEmpty() ? forward.peek(): "";
    }

    public String forward(int steps) {
        int maxStep = Integer.min(backward.size(), steps);
        while(maxStep-- > 0) {
            forward.push(backward.pop());
        }

        return forward.peek();
    }
}

public class DesignBrowserHistoryLeetcode1472 {
    public static void main(String[] args) {

    }
}
