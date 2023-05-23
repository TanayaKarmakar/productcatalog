package com.app.medium.design;

import java.util.Stack;

/**
 * @author t0k02w6 on 21/05/23
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
    if(backwardStack.isEmpty())
      return null;
    int maxStepsAllowed = Integer.min(steps, backwardStack.size() - 1);
    while(maxStepsAllowed-- > 0) {
      forwardStack.push(backwardStack.pop());
    }
    return backwardStack.peek();
  }

  public String forward(int steps) {
    if(forwardStack.isEmpty())
      return backwardStack.peek();
    int maxStepsAllowed = Integer.min(steps, forwardStack.size());
    while(maxStepsAllowed-- > 0) {
      backwardStack.push(forwardStack.pop());
    }
    return backwardStack.peek();
  }
}


public class DesignBrowserHistoryLeetcode1472 {
  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");
    browserHistory.visit("facebook.com");
    browserHistory.visit("youtube.com");
    System.out.println(browserHistory.back(1));
    System.out.println(browserHistory.back(1));
    System.out.println(browserHistory.forward(1));
    browserHistory.visit("linkedin.com");
    System.out.println(browserHistory.forward(2));
    System.out.println(browserHistory.back(2));
    System.out.println(browserHistory.back(7));
  }
}
