package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class IntervalListIntersectionLeetcode986 {
    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0)
            return new int[][]{};
        List<int[]> result = new ArrayList<>();
        int n = firstList.length;
        int m = secondList.length;

        int aIndx = 0;
        int bIndx = 0;
        while(aIndx < n && bIndx < m) {
            int start = Integer.max(firstList[aIndx][0], secondList[bIndx][0]);
            int end = Integer.min(firstList[aIndx][1], secondList[bIndx][1]);

            if(start <= end)
                result.add(new int[]{start, end});
            if(firstList[aIndx][1] < secondList[bIndx][1])
                aIndx++;
            else
                bIndx++;
        }

        int[][] finalAns = new int[result.size()][2];

        int j = 0;
        for(int[] current: result) {
            finalAns[j++] = current;
        }
        return finalAns;
    }

    public static void main(String[] args) {

    }
}
