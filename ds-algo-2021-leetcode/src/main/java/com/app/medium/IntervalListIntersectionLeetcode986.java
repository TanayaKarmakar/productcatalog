package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersectionLeetcode986 {
    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length) {
            int start = Integer.max(firstList[i][0], secondList[j][0]);
            int end = Integer.min(firstList[i][1], secondList[j][1]);

            if(start <= end)
                list.add(new int[]{start, end});

            if(firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        int[][] finalResult = new int[list.size()][];

        j = 0;
        for(int[] curr: list) {
            finalResult[j++] = curr;
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        int[][] result = intervalIntersection(firstList, secondList);

        for(int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
