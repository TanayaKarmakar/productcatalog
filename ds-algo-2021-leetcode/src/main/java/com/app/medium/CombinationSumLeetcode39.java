package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetcode39 {
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSumRec(candidates, 0, target, 0, current, result);
        return result;
    }

    private static void combinationSumRec(int[] candidates, int indx, int target, int sum,
                                          List<Integer> current, List<List<Integer>> result) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            List<Integer> newCurrent = new ArrayList<>(current);
            result.add(newCurrent);
            return;
        }

        for(int i = indx; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSumRec(candidates, i, target, sum + candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println(result);

        candidates = new int[]{2,3,5};
        target = 8;
        result = combinationSum(candidates, target);

        System.out.println(result);
    }
}
