package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 09/04/22
 * @project ds-algo-2021
 */
public class DiagonalTraverseLeetcode498 {
    private static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!map.containsKey(i + j))
                    map.put(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
            }
        }

        int j = 0;
        boolean rev = true;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> values = entry.getValue();
            if(rev) {
                Collections.reverse(values);
            }
            for(Integer el: values) {
                res[j++] = el;
            }
            rev = !rev;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ans = findDiagonalOrder(mat);

        System.out.println(Arrays.toString(ans));
    }
}
