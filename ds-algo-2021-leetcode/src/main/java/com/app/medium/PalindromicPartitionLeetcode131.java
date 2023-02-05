package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 03/02/23
 * @project ds-algo-2021
 */
public class PalindromicPartitionLeetcode131 {
  private static List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    partitionRec(s, 0, path, result);
    return result;
  }

  private static void partitionRec(String s, int indx, List<String> path, List<List<String>> result) {
    if(indx == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i = indx; i < s.length(); i++) {
      if(isPalindrome(s, indx, i)) {
        path.add(s.substring(indx, i + 1));
        partitionRec(s, i + 1, path, result);
        path.remove(path.size() - 1);
      }
    }
  }

  private static boolean isPalindrome(String s, int start, int end) {
    while(start <= end) {
      if(s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    String str = "a";
    List<List<String>> result = partition(str);

    System.out.println(result);
  }
}
