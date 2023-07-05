package com.app.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 20/06/23
 * @project ds-algo-2021-leetcode
 */
public class WordBreakLeetcode139 {
  private static boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] isWordBreak = new boolean[n + 1];
    Set<String> wordSet = new HashSet<>();
    wordSet.addAll(wordDict);

    isWordBreak[0] = true;

    for(int i = 1; i <= n; i++) {
      for(int j = 0; j < i; j++) {
        if(!isWordBreak[j])
          continue;
        String str = s.substring(j, i);
        if(wordSet.contains(str)) {
          isWordBreak[i] = true;
          break;
        }
      }
    }
    return isWordBreak[n];
  }

  public static void main(String[] args) {
    String s = "leetcode";
    List<String> wordDict = Arrays.asList("leet", "code");
    System.out.println(wordBreak(s, wordDict));

    s = "applepenapple";
    wordDict = Arrays.asList("apple", "pen");
    System.out.println(wordBreak(s, wordDict));

    s = "catsandog";
    wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
    System.out.println(wordBreak(s, wordDict));
  }
}
