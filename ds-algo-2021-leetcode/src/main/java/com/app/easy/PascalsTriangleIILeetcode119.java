package com.app.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIILeetcode119 {
    private static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> currentRow= List.of(1);
        rows.add(currentRow);

        for(int i = 1; i <= rowIndex; i++) {
            currentRow = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    int sum = rows.get(i - 1).get(j - 1)
                            + rows.get(i - 1).get(j);
                    currentRow.add(sum);
                }
            }
            rows.add(currentRow);
        }

        return rows.get(rowIndex);

    }

    public static void main(String[] args) {
        List<Integer> ans = getRow(3);

        System.out.println(ans);
    }
}
