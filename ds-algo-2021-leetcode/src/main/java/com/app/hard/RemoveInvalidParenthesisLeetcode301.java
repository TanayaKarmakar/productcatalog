package com.app.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 09/08/23
 * @project ds-algo-2021-leetcode
 */
public class RemoveInvalidParenthesisLeetcode301 {
  private static List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();
    if(isValid(s)) {
      result.add(s);
      return result;
    }

    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(s);
    visited.add(s);

    while(!queue.isEmpty()) {
      String currentItem = queue.poll();

      if(isValid(currentItem)) {
        result.add(currentItem);
      } else if(result.size() > 0)
        continue;

      for(int i = 0; i < currentItem.length(); i++) {
        char ch = currentItem.charAt(i);
        if(ch == '(' || ch == ')') {
          String left = "";
          String right = "";
          if(i == 0) {
            right = currentItem.substring(i + 1);
          } else if(i == currentItem.length() - 1) {
            left = currentItem.substring(0, i);
          } else {
            left = currentItem.substring(0, i);
            right = currentItem.substring(i + 1);
          }
          String newString = left + right;
          if(!visited.contains(newString)) {
            visited.add(newString);
            queue.add(newString);
          }
        }
      }
    }
    return result;
  }

  private static boolean isValid(String s) {
    int count = 0;
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(ch == '(')
        count++;
      else if(ch == ')')
        count--;
      if(count < 0)
        return false;
    }
    return count == 0;
  }

  public static void main(String[] args) {
    System.out.println(removeInvalidParentheses("()())()"));
    System.out.println(removeInvalidParentheses("(a)())()"));
  }
}
