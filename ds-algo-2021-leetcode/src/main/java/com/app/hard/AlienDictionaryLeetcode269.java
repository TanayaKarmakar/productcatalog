package com.app.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 31/01/23
 * @project ds-algo-2021
 */
public class AlienDictionaryLeetcode269 {
  private static String alienOrder(String[] words) {
    Map<Character, Set<Character>> adjList = new LinkedHashMap<>();
    Map<Character, Integer> inDegMap = new LinkedHashMap<>();

    for(String word: words) {
      for(char ch: word.toCharArray()) {
        inDegMap.put(ch, 0);
      }
    }

    for(int i = 0; i < words.length - 1; i++) {
      String current = words[i];
      String next = words[i + 1];
      int len = Integer.min(current.length(), next.length());
      for(int j = 0; j < len; j++) {
        char ch1 = current.charAt(j);
        char ch2 = next.charAt(j);
        if(ch1 != ch2) {
          if(!adjList.containsKey(ch1)) {
            adjList.put(ch1, new HashSet<>());
          }
          adjList.get(ch1).add(ch2);
          inDegMap.put(ch2, inDegMap.get(ch2) + 1);
          break;
        }
      }
    }

    int count = 0;
    StringBuilder sb = new StringBuilder();
    Queue<Character> q = new LinkedList<>();
    for(Map.Entry<Character, Integer> entry: inDegMap.entrySet()) {
      if(entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    while(!q.isEmpty()) {
      char rem = q.poll();
      count++;
      sb.append(rem);
      if(adjList.containsKey(rem)) {
        Set<Character> sets = adjList.get(rem);
        for(Character ch: sets) {
          inDegMap.put(ch, inDegMap.get(ch) - 1);
          if(inDegMap.get(ch) == 0)
            q.add(ch);
        }
      }
    }

//    System.out.println(inDegMap.size());
//    System.out.println(count);

    return count == inDegMap.size() ? sb.toString(): "";
  }

  public static void main(String[] args) {
    String[] words = {"ac","ab","zc","zb"};
    String ans = alienOrder(words);

    System.out.println(ans);
  }
}
