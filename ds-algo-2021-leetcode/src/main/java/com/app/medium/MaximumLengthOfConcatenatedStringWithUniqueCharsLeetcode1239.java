package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharsLeetcode1239 {
  private static int maxLength(List<String> arr) {
    int n = arr.size();
    int totalCombination = (int)Math.pow(2, n);
    int maxLen = 0;

    for(int i = 0; i < totalCombination; i++) {
      int current = i;

      StringBuilder sb = new StringBuilder();
      int j = 0;
      while(current != 0) {
        if((current & 1) == 1) {
          sb.append(arr.get(j));
        }
        current = current >> 1;
        j++;
      }
      if(!sb.toString().isEmpty()) {
        String str = sb.toString();
        int[] freq = new int[26];
        for(int k = 0; k < str.length(); k++) {
          freq[str.charAt(k) - 'a']++;
        }

        boolean allUnique = true;
        for(int k = 0; k < 26; k++) {
          if(freq[k] > 1) {
            allUnique = false;
          }
        }

        if(allUnique)
          maxLen = Integer.max(str.length(), maxLen);
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    List<String> strs = new ArrayList<>();
    strs.add("un");
    strs.add("iq");
    strs.add("ue");

    int ans = maxLength(strs);

    System.out.println(ans);
  }
}
