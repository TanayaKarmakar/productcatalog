package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class ValidMountainArrayLeetcode941 {
    private static boolean validMountainArray(int[] arr) {
        if(arr.length < 3)
            return false;

        int n = arr.length;
        for(int i = 1; i < n - 1; i++) {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                for(int j = 1; j <= i; j++) {
                    if(arr[j] <= arr[j - 1])
                        return false;
                }

                for(int j = i; j < n - 1; j++) {
                    if(arr[j] <= arr[j + 1])
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
