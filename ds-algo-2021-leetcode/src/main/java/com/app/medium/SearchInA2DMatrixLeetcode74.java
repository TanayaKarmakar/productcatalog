package com.app.medium;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class SearchInA2DMatrixLeetcode74 {
    private static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = (m - 1) * n + (n - 1);

        while(start <= end) {
            int mid = (start + end) >> 1;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
