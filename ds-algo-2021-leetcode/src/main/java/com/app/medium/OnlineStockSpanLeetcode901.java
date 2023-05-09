package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 09/05/23
 * @project ds-algo-2021-leetcode
 */

class StockSpanner {
  static class StockItem {
    int stockValue;
    int spanValue;

    public StockItem(int stockValue, int spanValue) {
      this.stockValue = stockValue;
      this.spanValue = spanValue;
    }
  }

  private Stack<StockItem> stockStack;

  public StockSpanner() {
    stockStack = new Stack<>();
  }

  public int next(int price) {
    int val = 1;
    if(stockStack.isEmpty() || stockStack.peek().stockValue > price) {
      stockStack.push(new StockItem(price, val));
    } else {
      while(!stockStack.isEmpty() && price >= stockStack.peek().stockValue) {
        StockItem currentItem = stockStack.pop();
        val += currentItem.spanValue;
      }
      stockStack.push(new StockItem(price, val));
    }
    return val;
  }
}


public class OnlineStockSpanLeetcode901 {
  public static void main(String[] args) {
    StockSpanner stockSpanner = new StockSpanner();
    System.out.println(stockSpanner.next(100));
    System.out.println(stockSpanner.next(80));
    System.out.println(stockSpanner.next(60));
    System.out.println(stockSpanner.next(70));
    System.out.println(stockSpanner.next(60));

  }
}
