package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 01/08/21
 * @project ds-algo-2021
 */
public class CombinationSumLeetcode39 {
    private static void combinationSum(List<List<Integer>> result, List<Integer> current, int[] candidates, int start, int target, int currentSum) {
        if(currentSum > target)
            return;
        if(currentSum == target) {
            List<Integer> newCurrent = new ArrayList<>();
            newCurrent.addAll(current);
            result.add(newCurrent);
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSum(result, current, candidates, i, target, currentSum + candidates[i]);
            current.remove(current.size() - 1);
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, new ArrayList<>(), candidates, 0, target, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }
}
