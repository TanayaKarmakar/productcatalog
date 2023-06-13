package com.app.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 06/06/23
 * @project ds-algo-2021-leetcode
 */
public class ReorganizeStringLeetcode767 {
  static class Item implements Comparable<Item> {
    char ch;
    int freq;

    public Item(char ch, int freq) {
      this.ch = ch;
      this.freq = freq;
    }

    @Override
    public int compareTo(Item o) {
      if(this.freq == o.freq)
        return this.ch - o.ch;
      return o.freq - this.freq;
    }
  }

  private static String reorganizeString(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Item> pQ = new PriorityQueue<>();
    for(Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
      pQ.add(new Item(entry.getKey(), entry.getValue()));
    }

    StringBuilder sb = new StringBuilder();
    while(!pQ.isEmpty()) {
      Item remItem1 = pQ.poll();
      if(sb.length() == 0 || remItem1.ch != sb.charAt(sb.length() - 1)) {
        sb.append(remItem1.ch);
        remItem1.freq = remItem1.freq - 1;
      } else {
        if(pQ.isEmpty())
          return "";
        Item remItem2 = pQ.poll();
        sb.append(remItem2.ch);
        remItem2.freq = remItem2.freq - 1;
        if(remItem2.freq > 0)
          pQ.add(remItem2);
      }
      if(remItem1.freq > 0)
        pQ.add(remItem1);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(reorganizeString("aab"));
    System.out.println(reorganizeString("aaab"));
  }
}
