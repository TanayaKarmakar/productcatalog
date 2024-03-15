package com.app.medium;

public class SpiralMatrixIILeetcode59 {
    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int startRow = 0;
        int endRow = (n - 1);
        int startCol = 0;
        int endCol = (n - 1);

        int val = 1;

        while(startRow <= endRow && startCol <= endCol) {
            for(int j = startCol;j <= endCol; j++) {
                matrix[startRow][j] = val++;
            }
            startRow++;

            for(int j = startRow; j <= endRow; j++) {
                matrix[j][endCol] = val++;
            }
            endCol--;

            for(int j = endCol; j >= startCol; j--) {
                matrix[endRow][j] = val++;
            }
            endRow--;

            for(int j = endRow; j >= startRow; j--) {
                matrix[j][startCol] = val++;
            }
            startCol++;
        }
        return matrix;
    }

    public static void main(String[] args) {

    }
}
