package com.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class GenerateParenthesisLeetcode22 {
  static class Item {
    String str;
    int open;
    int close;

    public Item(String str, int open, int close) {
      this.str = str;
      this.open = open;
      this.close = close;
    }
  }

  private static List<String> generateParenthesis(int n) {
    Queue<Item> queue = new LinkedList<>();
    queue.add(new Item("(", 1, 0));

    List<String> result = new ArrayList<>();

    while(!queue.isEmpty()) {
      Item polledItem = queue.poll();

      if(polledItem.open == polledItem.close && polledItem.open == n) {
        result.add(polledItem.str);
        continue;
      }

      if(polledItem.open < n) {
        queue.add(new Item(polledItem.str + "(", polledItem.open + 1, polledItem.close));
      }
      if(polledItem.open > polledItem.close) {
        queue.add(new Item(polledItem.str + ")", polledItem.open, polledItem.close+ 1));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int n = 3;
    List<String> res = generateParenthesis(n);

    System.out.println(res);
  }
}
