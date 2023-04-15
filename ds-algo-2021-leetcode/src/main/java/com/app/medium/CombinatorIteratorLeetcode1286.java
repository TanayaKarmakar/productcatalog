package com.app.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 10/04/23
 * @project ds-algo-2021-leetcode
 */

class CombinationIterator {
  private List<String> items;

  public CombinationIterator(String characters, int combinationLength) {
    this.items = new ArrayList<>();
    populateList(characters, combinationLength);
  }

  public String next() {
    return items.remove(0);
  }

  public boolean hasNext() {
    return !items.isEmpty();
  }

  private void populateList(String characters, int combinationLength) {
    int n = characters.length();
    int totalItems = (int)Math.pow(2, n);

    for(int i = 0; i < totalItems; i++) {
      int temp = i;
      int setBits = numOfSetBits(temp);
      if(setBits == combinationLength) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(temp != 0) {
          if((temp & 1) == 1) {
            sb.append(characters.charAt(j));
          }
          j++;
          temp = temp >> 1;
        }
        items.add(sb.toString());
      }
    }
    Collections.sort(items);
  }

  private int numOfSetBits(int x) {
    int count = 0;
    while(x != 0) {
      if((x & 1) == 1)
        count++;
      x = x >> 1;
    }
    return count;
  }
}

public class CombinatorIteratorLeetcode1286 {
  public static void main(String[] args) {
    CombinationIterator ci = new CombinationIterator("abc", 2);

    System.out.println(ci.next());
  }
}
