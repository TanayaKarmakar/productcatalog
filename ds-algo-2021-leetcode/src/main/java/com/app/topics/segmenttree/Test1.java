package com.app.topics.segmenttree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 12/02/23
 * @project ds-algo-2021
 */
public class Test1 {
  private static boolean allEven(Map<Character, Integer> freqMap) {
    if(freqMap.isEmpty())
      return false;
    for(Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
      if(entry.getValue() % 2 != 0)
        return false;
    }
    return true;
  }

  public static int solution(String S) {
    // Implement your solution here
    int n = S.length();
    Map<Character, Integer> freqMap = new HashMap<>();
    int maxlen = 0;
    int right = 0;
    int left = 0;

    while(right < n) {
      while(right < n) {
        char ch = S.charAt(right);
        freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        if(allEven(freqMap))
          break;
        right++;
      }

      if(allEven(freqMap)) {
        while(left <= right && !allEven(freqMap)) {
          char ch1 = S.charAt(left);
          int value = freqMap.getOrDefault(ch1, 0);
          if(value > 0) {
            value--;
            if(value == 0)
              freqMap.remove(ch1);
            else
              freqMap.put(ch1, value);
          }
        }
        maxlen = Integer.max(maxlen, right - left + 1);
      }
    }
    return maxlen;

  }

  public static void main(String[] args) {
    String s = "bdaaadadb";
    int ans = solution(s);

    System.out.println(ans);

    System.out.println(solution("zthtzh"));

    System.out.println(solution("abacb"));
  }
}
