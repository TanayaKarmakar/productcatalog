package com.app.easy;

public class KthMissingPositiveNumberLeetcode1539 {
    private static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            int missing = arr[mid] - (mid + 1);
            if(missing > k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start + k;
    }

    public static void main(String[] args) {

    }
}
