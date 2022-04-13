package com.app.medium;

/**
 * @author t0k02w6 on 12/04/22
 * @project ds-algo-2021
 */
public class CompareVersonNumbersLeetcode165 {
    private static int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");

        int m = version1Arr.length;
        int n = version2Arr.length;

        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            int version1Val = Integer.parseInt(version1Arr[i]);
            int version2Val = Integer.parseInt(version2Arr[j]);
            if(version1Val > version2Val)
                return 1;
            else if(version1Val < version2Val)
                return -1;
            i++;
            j++;
        }

        while(i < m) {
            int version1Val = Integer.parseInt(version1Arr[i]);
            if(version1Val != 0)
                return 1;
            i++;
        }

        while(j < n) {
            int version2Val = Integer.parseInt(version2Arr[j]);
            if(version2Val != 0)
                return -1;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
