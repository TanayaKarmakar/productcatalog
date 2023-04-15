package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 13/04/23
 * @project ds-algo-2021-leetcode
 */
public class PathInZigzagLabelledBinaryTreeLeetcode1104 {
  private static List<Integer> pathInZigZagTree(int label) {
    int height = (int)(Math.log(label) / Math.log(2))+ 1;
    int value = 1;
    boolean reverse = false;
    List<Integer> intermediateResult = new ArrayList<>();
    for(int i = 0; i <= height; i++) {
      int numElements = (int)Math.pow(2, i);
      List<Integer> currentLevel = new ArrayList<>();
      int lastItem = value + numElements;
      while(value < lastItem) {
        currentLevel.add(value);
        value++;
      }
      if(reverse)
        Collections.reverse(currentLevel);
      intermediateResult.addAll(currentLevel);
      reverse = !reverse;
    }

    List<Integer> finalResult = new ArrayList<>();
    int i = 0;
    for(i = intermediateResult.size() - 1; i >= 0; i--) {
      if(intermediateResult.get(i) == label) {
        break;
      }
    }

    while(i > 0) {
      finalResult.add(0,intermediateResult.get(i));
      i = (i - 1)/2;
    }

    finalResult.add(0,intermediateResult.get(0));

    //System.out.println(finalResult);

    return finalResult;
  }

  public static void main(String[] args) {
    pathInZigZagTree(15);
  }
}
