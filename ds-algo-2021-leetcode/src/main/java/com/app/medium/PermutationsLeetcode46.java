package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 25/09/22
 * @project ds-algo-2021-leetcode
 */
public class PermutationsLeetcode46 {
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for(int num: nums) {
            current.add(num);
        }

        permutationRec(current, result, 0);
        return result;
    }

    private static void permutationRec(List<Integer> current, List<List<Integer>> result, int indx) {
        if(indx == current.size()) {
            List<Integer> newList = new ArrayList<>(current);
            result.add(newList);
            return;
        }

        for(int i = indx; i < current.size(); i++) {
            swap(current, indx, i);
            permutationRec(current, result, indx + 1);
            swap(current, indx, i);
        }
    }

    private static void swap(List<Integer> current, int i, int j) {
        int tmp = current.get(i);
        current.set(i, current.get(j));
        current.set(j, tmp);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> res = permute(nums);

        System.out.println(res);
    }
}
