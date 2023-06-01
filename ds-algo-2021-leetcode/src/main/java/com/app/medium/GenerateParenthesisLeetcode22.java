package com.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class GenerateParenthesisLeetcode22 {
  static class Item {
    String val;
    int open;
    int close;

    public Item(String val, int open, int close) {
      this.val = val;
      this.open = open;
      this.close = close;
    }
  }

  private static List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();

    Queue<Item> q = new LinkedList<>();
    q.add(new Item("(", 1, 0));

    while(!q.isEmpty()) {
      Item remItem = q.poll();
      if(remItem.open == remItem.close && remItem.open == n) {
        result.add(remItem.val);
        continue;
      }
      if(remItem.open < n) {
        q.add(new Item(remItem.val + "(" , remItem.open + 1, remItem.close));
      }
      if(remItem.close < remItem.open) {
        q.add(new Item(remItem.val + ")", remItem.open, remItem.close + 1));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> res = generateParenthesis(0);

    System.out.println(res);
  }
}
