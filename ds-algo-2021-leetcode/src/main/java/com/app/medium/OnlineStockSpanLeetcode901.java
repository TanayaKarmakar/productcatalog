package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 02/07/23
 * @project ds-algo-2021-leetcode
 */
public class OnlineStockSpanLeetcode901 {
  static class StockSpanner {
    static class StockItem {
      int indx;
      int value;

      public StockItem(int indx, int value) {
        this.indx = indx;
        this.value = value;
      }
    }

    private Stack<StockItem> stack;

    public StockSpanner() {
      stack = new Stack<>();
    }

    public int next(int price) {
      int value = 1;
      if(stack.isEmpty() || stack.peek().value > price) {
        stack.push(new StockItem(value, price));
      } else {
        while(!stack.isEmpty() && stack.peek().value <= price) {
          StockItem stockItem = stack.pop();
          value += stockItem.indx;
        }
        stack.push(new StockItem(value, price));
      }
      return value;
    }
  }

  public static void main(String[] args) {

  }
}
