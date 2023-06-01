package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 23/05/23
 * @project ds-algo-2021-leetcode
 */
public class PalindromePartitionLeetcode131 {
  private static List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> current = new ArrayList<>();
    partitionRec(s, 0, current, result);
    return result;
  }

  private static void partitionRec(String s, int indx, List<String> current, List<List<String>> result) {
    if(indx == s.length()) {
      result.add(new ArrayList<>(current));
      return;
    }

    for(int i = indx; i < s.length(); i++) {
      if(isPalindrome(s, indx, i)) {
        current.add(s.substring(indx, i + 1));
        partitionRec(s, i + 1, current, result);
        current.remove(current.size() - 1);
      }
    }
  }

  private static boolean isPalindrome(String s, int start, int end) {
    while(start <= end) {
      if(s.charAt(start) != s.charAt(end))
        return false;
      start++;
      end--;
    }
    return true;
  }


  public static void main(String[] args) {
    String s = "aab";
    List<List<String>> result = partition(s);

    System.out.println(result);
  }
}
