package com.app.medium.design;

import java.util.Stack;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */

class BrowserHistory {
  private Stack<String> backwardStack;
  private Stack<String> forwardStack;

  public BrowserHistory(String homepage) {
    backwardStack = new Stack<>();
    forwardStack = new Stack<>();
    backwardStack.push(homepage);
  }

  public void visit(String url) {
    if(!forwardStack.isEmpty()) {
      forwardStack.clear();
    }
    backwardStack.push(url);
  }

  public String back(int steps) {
    int maxSteps = Integer.min(steps, backwardStack.size() - 1);
    while(maxSteps-- > 0) {
      forwardStack.push(backwardStack.pop());
    }
    return backwardStack.peek();
  }

  public String forward(int steps) {
    int maxSteps = Integer.min(steps, forwardStack.size());
    while(maxSteps-- > 0) {
      backwardStack.push(forwardStack.pop());
    }
    return backwardStack.peek();
  }
}


public class DesignBrowserHistoryLeetcode1472 {
  public static void main(String[] args) {

  }
}
