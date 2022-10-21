package com.app.medium;

/**
 * @author t0k02w6 on 17/10/22
 * @project ds-algo-2021-leetcode
 */
public class LongestSubstringAtleastKRepeatingCharactersLeetcode395 {
  private static int longestSubstring(String s, int k) {
    return helper(s.toCharArray(), 0, s.length(), k);
  }

  private static int helper(char[] arr, int start, int end, int k) {
    if(end - start < k)
      return 0;
    int[] count = new int[26];
    for(int i = start; i < end; i++) {
      count[arr[i] - 'a']++;
    }

    for(int i = start; i < end; i++) {
      if(count[arr[i]- 'a'] < k) {
        int j = i + 1;
        while(j < end && count[arr[i] - 'a'] < k)
          j++;
        return Integer.max(helper(arr, start, i, k),
            helper(arr, j, end, k));
      }
    }
    return (end - start);
  }

  public static void main(String[] args) {

    System.out.println(longestSubstring("aaabb", 3));

  }
}
