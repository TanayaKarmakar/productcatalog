package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */
public class PermutationInStringLeetcode567 {
  private static boolean checkInclusion(String s1, String s2) {
    if(s2.length() < s1.length())
      return false;
    int[] s1Freq = new int[26];
    int[] s2Freq = new int[26];

    int n = s2.length();

    int windowSize = s1.length();
    int i = 0;
    for(i = 0; i < windowSize; i++) {
      s1Freq[s1.charAt(i) - 'a']++;
      s2Freq[s2.charAt(i) - 'a']++;
    }

    if(Arrays.equals(s1Freq, s2Freq))
      return true;

    int j = 0;
    while(i < n) {
      s2Freq[s2.charAt(j) - 'a']--;
      s2Freq[s2.charAt(i) - 'a']++;
      if(Arrays.equals(s1Freq, s2Freq))
        return true;
      i++;
      j++;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eidbaooo"));
    System.out.println(checkInclusion("ab", "eidboaoo"));
  }
}
