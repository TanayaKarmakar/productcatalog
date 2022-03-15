package com.app.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class PascalsTriangleLeetcode118 {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        row.add(1);
        list.add(row);

        for(int i = 1; i < numRows; i++) {
            row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    int sum = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                    row.add(sum);
                }
            }
            list.add(row);
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
