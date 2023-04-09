package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author t0k02w6 on 09/04/23
 * @project ds-algo-2021-leetcode
 */
public class BraceExpansionLeetcode1087 {
  private static String[] expand(String s) {
    if(s.indexOf('{') == -1) {
      return new String[]{s};
    }

    List<List<String>> tokens = new ArrayList<>();
    Stack<String> stack = new Stack<>();


    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(ch == '}') {
        List<String> exprList = new ArrayList<>();
        while(!stack.isEmpty() && !stack.peek().equals("{")) {
          exprList.add(0, stack.pop());
        }
        stack.pop();

        if(!stack.isEmpty()) {
          List<String> txtList = new ArrayList<>();
          while(!stack.isEmpty()) {
            txtList.add(0, stack.pop());
          }
          tokens.add(txtList);
        }

        tokens.add(exprList);
      } else {
        if(ch != ',')
          stack.push(ch + "");
      }
    }

    if(!stack.isEmpty()) {
      List<String> txtList = new ArrayList<>();
      while(!stack.isEmpty()) {
        txtList.add(0, stack.pop());
      }
      tokens.add(txtList);
    }

    Queue<String> q = new LinkedList<>();

    for(List<String> token: tokens) {
      if(q.isEmpty()) {
        q.addAll(token);
      } else {
        int size = q.size();
        for(int i = 0; i < size; i++) {
          String remItem = q.poll();
          for(String el: token) {
            q.add(remItem + el);
          }
        }
      }
    }


    int size = q.size();
    String[] result = new String[size];

    int i = 0;
    while(!q.isEmpty()) {
      result[i++] = q.poll();
    }

    Arrays.sort(result);

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(expand("{a,b}c{d,e}f")));
    System.out.println(Arrays.toString(expand("abcd")));
  }
}
