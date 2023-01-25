package com.app.topics.segmenttree;

/**
 * @author t0k02w6 on 05/12/22
 * @project ds-algo-2021
 */
public class BalancedParanthesisInRange {
  static class Item {
    int open;
    int close;
    int full;
  }

  private static Item merge(Item left, Item right) {
    Item newItem = new Item();
    newItem.open = left.open + right.open - Integer.min(left.open, right.close);
    newItem.close = left.close + right.close - Integer.min(left.open, right.close);
    newItem.full = left.full + right.full + Integer.min(left.open, right.close);
    return newItem;
  }

  private static Item query(Item[] seg, int low, int high, int l, int r, int indx) {
    if(low > r || high < l) {
      return new Item();
    }
    if(low >= l && high <= r) {
      return seg[indx];
    }
    int mid = (low + high) >> 1;
    Item left = query(seg, low, mid, l, r, 2 * indx + 1);
    Item right = query(seg, mid + 1, high, l, r, 2 * indx + 2);
    return merge(left, right);
  }

  private static void build(Item[] seg, int low, int high, String str, int indx) {
    if(low == high) {
      Item newItem = new Item();
      if(str.charAt(low) == '(') {
        newItem.open = newItem.open + 1;
      } else {
        newItem.close = newItem.close + 1;
      }
      seg[indx] = newItem;
      return;
    }

    int mid = (low + high) >> 1;
    build(seg, low, mid, str, 2 * indx + 1);
    build(seg, mid + 1, high, str, 2 * indx + 2);

    seg[indx] = merge(seg[2 * indx + 1], seg[2 * indx + 2]);
  }

  public static void main(String[] args) {
    String str = ")(()())((())";
    int n = str.length();
    Item[] seg = new Item[4 * n];
    build(seg, 0, n - 1, str, 0);
    int l = 1;
    int r = 4;

    Item ans = query(seg, 0, n - 1, l, r, 0);

    System.out.println(ans.full * 2);
  }
}
