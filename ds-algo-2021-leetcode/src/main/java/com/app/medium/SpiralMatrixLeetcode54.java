package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
public class SpiralMatrixLeetcode54 {
    private static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;
        List<Integer> result = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol) {
            for(int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
            startRow++;

            for(int j = startRow; j <= endRow; j++) {
                result.add(matrix[j][endCol]);
            }
            endCol--;

            if(startRow <= endRow) {
                for(int j = endCol; j >= startCol; j--) {
                    result.add(matrix[endRow][j]);
                }
               endRow--;
            }

            if(startCol <= endCol) {
                for(int j = endRow; j >= startRow; j--) {
                    result.add(matrix[j][startCol]);
                }
                startCol++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        List<Integer> result = spiralOrder(matrix);

        System.out.println(result);
    }
}
