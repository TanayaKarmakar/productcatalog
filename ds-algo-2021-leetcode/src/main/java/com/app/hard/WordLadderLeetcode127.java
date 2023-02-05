package com.app.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */
public class WordLadderLeetcode127 {
  private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, List<String>> map = new HashMap<>();
    buildAdjacencyList(map, wordList, beginWord);

    for(String item: wordList)
      buildAdjacencyList(map, wordList, item);
    if(!map.containsKey(beginWord) || !map.containsKey(endWord))
      return 0;
    Set<String> visited = new HashSet<>();
    if(!map.containsKey(endWord))
      return 0;
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    visited.add(beginWord);
    int count = 0;

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        String currentWord = q.poll();
        if(currentWord.equals(endWord))
          return count;
        List<String> neighbors = map.get(currentWord);
        for(String nei: neighbors) {
          if(!visited.contains(nei)) {
            q.add(nei);
            visited.add(nei);
          }
        }
      }
      count++;
    }
    return 0;
  }

  private static void buildAdjacencyList(Map<String, List<String>> map, List<String> wordList, String currentWord) {
    if(map.containsKey(currentWord))
      return;
    String str = currentWord;
    map.put(str, new ArrayList<>());
    for(String item: wordList) {
      if(str.equals(item))
        continue;
      if(calculateDiff(str, item) == 1) {
        map.get(str).add(item);
        if(!map.containsKey(item))
          map.put(item, new ArrayList<>());
        map.get(item).add(str);
      }
    }
  }

  private static int calculateDiff(String str1, String str2) {
    if(str1.length() != str2.length())
      return Integer.MAX_VALUE;
    int diffCount = 0;
    for(int i = 0; i < str1.length(); i++) {
      if(str1.charAt(i) != str2.charAt(i))
        diffCount++;
      if(diffCount > 1)
        return diffCount;
    }
    return diffCount;
  }

  public static void main(String[] args) {
//    String beginWord = "hit";
//    String endWord = "cog";
//    List<String> wordList = new ArrayList<>();
//    wordList.add("hot");
//    wordList.add("dot");
//    wordList.add("dog");
//    wordList.add("lot");
//    wordList.add("log");
//    wordList.add("cog");
//
//
//    int ans = ladderLength(beginWord, endWord, wordList);
//
//    System.out.println(ans);

    String beginWord = "a";
    String endWord = "c";
    List<String> wordList = new ArrayList<>();
    wordList.add("a");
    wordList.add("b");
    wordList.add("c");


    int ans = ladderLength(beginWord, endWord, wordList);

    System.out.println(ans);
  }
}
