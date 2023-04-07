package com.app.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class WordBreakLeetcode139 {
  private static boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] isPresent = new boolean[n + 1];

    Set<String> wordSet = new HashSet<>();
    wordSet.addAll(wordDict);

    isPresent[0] = true;

    for(int i = 1; i <= n; i++) {
      for(int j = 0; j < i; j++) {
        if(!isPresent[j])
          continue;
        if(wordSet.contains(s.substring(j, i))) {
          isPresent[i] = true;
          break;
        }
      }
    }
    return isPresent[n];
  }

  public static void main(String[] args) {
    List<String> wordDict = new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");

    String s = "leetcode";

    System.out.println(wordBreak(s, wordDict));

    wordDict.clear();
    wordDict.add("apple");
    wordDict.add("pen");

    s = "applepenapple";
    System.out.println(wordBreak(s, wordDict));

    wordDict.clear();
    wordDict.add("cats");
    wordDict.add("dog");
    wordDict.add("sand");
    wordDict.add("and");
    wordDict.add("cat");

    s = "catsandog";

    System.out.println(wordBreak(s, wordDict));
  }
}
