package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
public class CombinationSumIILeetcode40 {
  private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    combinationSumRec(candidates, target, 0, result, current);
    return result;
  }

  private static void combinationSumRec(int[] candidates, int target, int i, List<List<Integer>> result, List<Integer> current) {
    if(i >= candidates.length || target < 0)
      return;
    if(target == 0) {
      List<Integer> newList = new ArrayList<>();
      newList.addAll(current);
      result.add(newList);
      return;
    }
    for(int indx = i; indx < candidates.length; indx++) {
      if(indx != i && candidates[indx - 1] == candidates[indx])
        continue;
      current.add(candidates[indx]);
      combinationSumRec(candidates, target - candidates[indx], indx + 1, result, current);
      current.remove(current.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {10,1,2,7,6,1,5};
    int target = 8;

    List<List<Integer>> result = combinationSum2(nums, target);

    System.out.println(result);
  }
}
