package com.app.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 30/07/23
 * @project ds-algo-2021-leetcode
 */
public class ConcatenatedWordsLeetcode472 {
  private static List<String> findAllConcatenatedWordsInADict(String[] words) {
    if(words.length <= 1)
      return new ArrayList<>();
    List<String> result = new ArrayList<>();

    Set<String> wordDictSet = new HashSet<>();
    for(String word: words) {
      wordDictSet.add(word);
    }

    for(String word: words) {
      if(word.equals(""))
        continue;
      wordDictSet.remove(word);
      if(canBreak(wordDictSet, word)) {
        result.add(word);
      }
      wordDictSet.add(word);
    }
    return result;
  }

  private static boolean canBreak(Set<String> wordDictSet, String word) {
    int n = word.length();
    boolean[] isWordBreak = new boolean[n + 1];
    isWordBreak[0] = true;

    for(int i = 1; i <= n; i++) {
      for(int j = 0; j < n; j++) {
        if(!isWordBreak[j]) {
          continue;
        }
        String substr = word.substring(j, i);
        if(wordDictSet.contains(substr)) {
          isWordBreak[i] = true;
          break;
        }
      }
    }
    return isWordBreak[n];
  }


  public static void main(String[] args) {

  }
}
