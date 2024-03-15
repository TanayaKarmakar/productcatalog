package com.app.medium;

public class SearchInA2DMatrixLeetcode74 {
    private static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int totalLen = (m * n) - 1;
        int start = 0;
        int end = totalLen;

        while(start <= end) {
            int mid = (start + end) >> 1;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
