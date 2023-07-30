package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class PathInZigzagLabelledBinaryTreeLeetcode1104 {
  private static List<Integer> pathInZigZagTree(int label) {
    int height = (int)(Math.log(label) / Math.log(2));

    List<Integer> treeNodes = new ArrayList<>();

    int value = 1;
    boolean reverse = false;
    for(int i = 0; i <= height; i++) {
      int nElements = (int)Math.pow(2, i);
      List<Integer> elementsAtCurrLevel = new ArrayList<>();
      int start = value;
      int end = value + nElements;
      for(int j = start; j < end; j++) {
        elementsAtCurrLevel.add(j);
      }

      value = end;
      if(reverse) {
        Collections.reverse(elementsAtCurrLevel);
      }
      treeNodes.addAll(elementsAtCurrLevel);
      reverse = !reverse;
    }

    List<Integer> result = new ArrayList<>();
    int i = treeNodes.size() - 1;
    while(i >= 0 && treeNodes.get(i) != label) {
      i--;
    }

    result.add(treeNodes.get(i));
    while(i > 0) {
      i = (i - 1)/2;
      result.add(0, treeNodes.get(i));
    }

    //result.add(treeNodes.get(0));
    return result;
  }

  public static void main(String[] args) {
    List<Integer> result = pathInZigZagTree(14);

    System.out.println(result);

    result = pathInZigZagTree(26);

    System.out.println(result);
  }
}
