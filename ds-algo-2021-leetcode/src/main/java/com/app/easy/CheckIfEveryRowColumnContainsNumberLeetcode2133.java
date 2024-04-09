package com.app.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckIfEveryRowColumnContainsNumberLeetcode2133 {
    private static boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        Set<Integer> colSet = new HashSet<>();
        List<Set<Integer>> rowSet = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            rowSet.add(new HashSet<>());
        }

        for(int i = 0; i < n; i++) {
            colSet = new HashSet<>();
            for(int j = 0; j < n; j++) {
                colSet.add(matrix[i][j]);
                rowSet.get(j).add(matrix[i][j]);
            }

            if(colSet.size() < n)
                return false;
        }

        for(int i = 0; i < n; i++) {
            if(rowSet.get(i).size() < n)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
