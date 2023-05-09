package com.app.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 09/05/23
 * @project ds-algo-2021-leetcode
 */
public class ReorganizeStringLeetcode767 {
  static class QueueItem implements Comparable<QueueItem> {
    char ch;
    int freq;

    public QueueItem(char ch, int freq) {
      this.ch = ch;
      this.freq = freq;
    }

    @Override
    public int compareTo(QueueItem o) {
      if(this.freq == o.freq)
        return this.ch - o.ch;
      return o.freq - this.freq;
    }
  }

  private static String reorganizeString(String s) {
    Map<Character, Integer> charMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<QueueItem> pQ = new PriorityQueue<>();
    for(Map.Entry<Character, Integer> entry: charMap.entrySet()) {
      QueueItem qItem = new QueueItem(entry.getKey(), entry.getValue());
      pQ.add(qItem);
    }

    StringBuilder sb = new StringBuilder();
    while(!pQ.isEmpty()) {
      QueueItem qItem = pQ.poll();
      if(sb.length() == 0 || sb.charAt(sb.length() - 1) != qItem.ch) {
        sb.append(qItem.ch);
        qItem.freq = qItem.freq - 1;
      } else {
        if(pQ.isEmpty())
          return "";
        QueueItem anotherItem = pQ.poll();
        sb.append(anotherItem.ch);
        anotherItem.freq = anotherItem.freq - 1;
        if(anotherItem.freq > 0)
          pQ.add(anotherItem);
      }
      if(qItem.freq > 0)
        pQ.add(qItem);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(reorganizeString("aab"));
    System.out.println(reorganizeString("aaab"));
  }
}
