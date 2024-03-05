package com.app.medium;

import java.util.*;

public class DiagonalTraverseLeetcode498 {
    private static int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int key = (i + j);
                if(!map.containsKey(key))
                    map.put(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean rev = true;

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if(rev) {
                Collections.reverse(entry.getValue());
            }
            result.addAll(entry.getValue());
            rev = !rev;
        }

        int[] finalResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[] result = findDiagonalOrder(matrix);

        System.out.println(Arrays.toString(result));
    }
}
