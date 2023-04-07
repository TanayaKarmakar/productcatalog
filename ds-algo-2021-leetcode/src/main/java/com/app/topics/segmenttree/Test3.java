package com.app.topics.segmenttree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/02/23
 * @project ds-algo-2021
 */
public class Test3 {
  private static int solution(String S) {
    // Implement your solution here
    int countLeft = 0;
    int countRight = 0;
    if(!S.contains("<") && !S.contains(">")) {
      if(S.length() % 2 == 0)
        return S.length();
      else
        return S.length() - 1;
    }

    List<Integer> unknownPos = new ArrayList<>();
    char[] arr = S.toCharArray();
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == '<')
        countLeft++;
      else if(arr[i] == '>')
        countRight++;
      else
        unknownPos.add(i);
    }

    char replacedChar;
    if(countLeft > countRight) {
      replacedChar = '>';
    } else {
      replacedChar = '<';
    }

    for(Integer el: unknownPos) {
      arr[el] = replacedChar;
    }

    S = new String(arr);

    int maxLen = 0;
    for(int i = 0; i < S.length(); i++) {
      for(int j = i + 2; j <= S.length(); j += 2) {
        String s = S.substring(i, j);
        if(s.length() % 2 == 0 && isSymmetric(s)) {
          maxLen = Integer.max(maxLen, j - i);
        }
      }
    }
    return maxLen;
  }

  private static boolean isSymmetric(String s) {
    int n = s.length();
    int mid = n / 2;
    int countLeft = 0;
    int countRight = 0;
    for(int i = 0; i < mid; i++) {
      if(s.charAt(i) != '<')
        return false;
      countLeft++;
    }

    for(int i = mid; i < n; i++) {
      if(s.charAt(i) != '>')
        return false;
      countRight++;
    }
    return countLeft == countRight;
  }

  public static void main(String[] args) {
    System.out.println(solution("<<?"));
  }
}
