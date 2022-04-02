package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 01/04/22
 * @project ds-algo-2021
 */
public class CombinationLeetcode39 {

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
        combinationSumRec(candidates, target, 0, result, currentResult);
        return result;
    }

    private static void combinationSumRec(int[] candidates, int target, int currentIndx, List<List<Integer>> result, List<Integer> currentResult) {
        if(target < 0 || currentIndx >= candidates.length)
            return;
        if(target == 0) {
            List<Integer> newList = new ArrayList<>();
            for(Integer el: currentResult) {
                newList.add(el);
            }
            result.add(newList);
            return;
        }

        for(int i = currentIndx; i < candidates.length; i++) {
            currentResult.add(candidates[i]);
            combinationSumRec(candidates, target - candidates[i], i, result, currentResult);
            currentResult.remove(currentResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(nums, target);

        System.out.println(res);
    }
}
