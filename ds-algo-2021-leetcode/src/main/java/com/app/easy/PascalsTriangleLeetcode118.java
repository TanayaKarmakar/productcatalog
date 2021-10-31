package com.app.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 30/10/21
 * @project ds-algo-2021
 */
public class PascalsTriangleLeetcode118 {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> col = new ArrayList<>();
        col.add(1);
        res.add(col);

        for(int i = 1; i < numRows; i++) {
            col = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    col.add(1);
                else {
                    int sum = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    col.add(sum);
                }
            }
            res.add(col);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        List<List<Integer>> res = generate(numRows);

        System.out.println(res);
    }
}
