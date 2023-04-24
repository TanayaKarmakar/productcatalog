package com.app.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestStringChainLeetcode1048 {
  private static int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));

    int n = words.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for(int i = n - 1; i > 0; i--) {
      for(int j = i - 1; j >= 0; j--) {
        if(words[i].length() == words[j].length())
          continue;
        if(words[i].length() > words[j].length() + 1)
          break;

        if(numCharsInserted(words[i], words[j]))
          dp[j] = Integer.max(dp[j], dp[i] + 1);
      }
    }

    int maxLen = 1;
    for(int i = 0; i <dp.length; i++) {
      maxLen = Integer.max(maxLen, dp[i]);
    }
    return maxLen;
  }

  private static boolean numCharsInserted(String target, String source) {
    int i = 0;
    int j = 0;
    int count = 0;
      while (i < target.length() && j < source.length()) {
        if (target.charAt(i) != source.charAt(j)) {
          count++;
          if (count > 1)
            return false;
        } else {
          j++;
        }
        i++;
      }
      return true;
  }

  public static void main(String[] args) {
    System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    System.out.println(longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
  }
}
