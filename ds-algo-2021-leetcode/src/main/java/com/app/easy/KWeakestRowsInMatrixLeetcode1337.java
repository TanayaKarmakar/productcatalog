package com.app.easy;

import com.app.common.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
class ValueComparator implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        if(o1.second.equals(o2.second))
            return o1.first - o2.first;
        return o2.second - o1.second;
    }
}

public class KWeakestRowsInMatrixLeetcode1337 {
    private static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer, Integer>> pQ = new PriorityQueue<>(new ValueComparator());
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++) {
            int count = 0;
            int j = 0;
            while(j < n && mat[i][j] == 1) {
                count++;
                j++;
            }
            Pair<Integer, Integer> newPair = new Pair<>(i, (n - count));
            pQ.add(newPair);
        }

        int[] result = new int[k];
        int i = 0;
        while(!pQ.isEmpty() && i < k) {
            Pair<Integer, Integer> rem = pQ.poll();
            result[i++] = rem.first;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k = 3;

        int[] ans = kWeakestRows(mat, k);
        System.out.println(Arrays.toString(ans));
    }
}
