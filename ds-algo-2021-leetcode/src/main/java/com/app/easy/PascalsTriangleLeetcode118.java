package com.app.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleLeetcode118 {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    int val = result.get(i - 1).get(j - 1)
                            + result.get(i - 1).get(j);
                    row.add(val);
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }
}
