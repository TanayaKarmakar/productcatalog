package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharactersLeetcode1239 {
  private static int maxLength(List<String> arr) {
    int size = arr.size();
    int totalCombinations = (int)Math.pow(2, size);

    int maxLen = 0;
    for(int i = 0; i < totalCombinations; i++) {
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
      String str = sb.toString();
      int[] charFreq = new int[26];
      boolean isUniq = true;
      for(int k = 0; k < str.length(); k++) {
        int charIndx = str.charAt(k) - 'a';
        if(charFreq[charIndx] > 0) {
          isUniq = false;
          break;
        }
        charFreq[charIndx]++;
      }
      if(isUniq) {
        maxLen = Integer.max(maxLen, str.length());
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    List<String> arr = new ArrayList<>();
    arr.add("un");
    arr.add("iq");
    arr.add("ue");

    int ans = maxLength(arr);

    System.out.println(ans);
  }
}
