package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 07/06/23
 * @project ds-algo-2021-leetcode
 */
public class CombinationSumLeetcode39 {
  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> finalResult = new ArrayList<>();
    List<Integer> currentResult = new ArrayList<>();
    combinationSumRec(candidates, target, 0, finalResult, currentResult, 0);
    return finalResult;
  }

  private static void combinationSumRec(int[] candidates, int target, int currentTarget, List<List<Integer>> finalResult, List<Integer> currentResult, int start) {
    if(currentTarget > target) {
      return;
    }
    if(currentTarget == target) {
      List<Integer> newResult = new ArrayList<>(currentResult);
      finalResult.add(newResult);
      return;
    }

    for(int i = start; i < candidates.length; i++) {
      currentResult.add(candidates[i]);
      combinationSumRec(candidates, target, currentTarget + candidates[i], finalResult, currentResult, i);
      currentResult.remove(currentResult.size() - 1);
    }

  }

  public static void main(String[] args) {
    int[] candidates = {2,3,5};
    int target = 8;

    List<List<Integer>> result = combinationSum(candidates, target);
    System.out.println(result);
  }
}
