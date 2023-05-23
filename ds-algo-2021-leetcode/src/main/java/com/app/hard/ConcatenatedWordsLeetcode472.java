package com.app.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 22/05/23
 * @project ds-algo-2021-leetcode
 */
public class ConcatenatedWordsLeetcode472 {
  private static List<String> findAllConcatenatedWordsInADict(String[] words) {
    Set<String> wordSet = new HashSet<>();

    wordSet.addAll(Arrays.asList(words));
    
    List<String> result = new ArrayList<>();
    for(String word: words) {
      if(word.equals(""))
        continue;
      wordSet.remove(word);
      if(hasFormedByMoreWords(word, wordSet)) {
        result.add(word);
      }
      wordSet.add(word);
    }
    return result;
  }

  private static boolean hasFormedByMoreWords(String word, Set<String> wordSet) {
    int n = word.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for(int i = 1; i <= n; i++) {
      for(int j = 0; j < i; j++) {
        if(!dp[j])
          continue;
        String sub = word.substring(j, i);
        if(wordSet.contains(sub)) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    List<String> result = findAllConcatenatedWordsInADict(words);

    System.out.println(result);


  }
}
