package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIILeetcode40 {
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
        combinationRec(candidates, 0, target, result, currentResult);
        return result;
    }

    private static void combinationRec(int[] candidates, int indx, int target, List<List<Integer>> result, List<Integer> currentResult) {
        if(target == 0) {
            List<Integer> newList = new ArrayList<>(currentResult);
            result.add(newList);
            return;
        }
        if(indx >= candidates.length || target < 0)
            return;
        for(int currentIndx = indx; currentIndx < candidates.length; currentIndx++) {
            if(currentIndx != indx && candidates[currentIndx - 1] == candidates[currentIndx])
                continue;
            currentResult.add(candidates[currentIndx]);
            combinationRec(candidates, currentIndx + 1, target - candidates[currentIndx], result, currentResult);
            currentResult.remove(currentResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);

        System.out.println(result);
    }
}
