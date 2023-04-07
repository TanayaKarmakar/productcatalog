package com.app.medium;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestSubstringAtleastKRepeatingCharsLeetcode395 {

  private static int longestSubstring(String s, int k) {
    return helper(s, 0, s.length(), k);
  }

  private static int helper(String s, int start, int end, int k) {
    if(end - start < k)
      return 0;
    int[] freq = new int[26];
    for(int i = start; i < end; i++) {
      freq[s.charAt(i) - 'a']++;
    }

    for(int i = start; i < end; i++) {
      if(freq[s.charAt(i) - 'a'] < k) {
        int j = i + 1;
        while(j < end && freq[s.charAt(j) - 'a'] < k) {
          j++;
        }

        return Integer.max(helper(s, start, i, k), helper(s, j, end, k));
      }
    }
    return (end - start);
  }

  public static void main(String[] args) {
    System.out.println(longestSubstring("aaabb", 3));
  }
}
