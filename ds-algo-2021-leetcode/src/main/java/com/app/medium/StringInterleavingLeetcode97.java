package com.app.medium;

/**
 * @author t0k02w6 on 22/09/22
 * @project ds-algo-2021-leetcode
 */
public class StringInterleavingLeetcode97 {
    private static boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() == 0 && s2.length() == 0) {
            if(s3.length() == 0)
                return true;
            else
                return false;
        }

        int m = s1.length();
        int n = s2.length();
        boolean[][] interleavingDp = new boolean[m + 1][n + 1];
        interleavingDp[0][0] = true;
        for(int i = 1; i <= m; i++) {
            if(s1.charAt(i - 1) == s3.charAt(i - 1)) {
                interleavingDp[i][0] = interleavingDp[i - 1][0];
            }
        }

        for(int j = 1; j <= n; j++) {
            if(s2.charAt(j - 1) == s3.charAt(j - 1)) {
                interleavingDp[0][j] = interleavingDp[0][j - 1];
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    interleavingDp[i][j] = interleavingDp[i - 1][j];
                }
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    interleavingDp[i][j] = interleavingDp[i][j] || interleavingDp[i][j - 1];
                }
            }
        }
        return interleavingDp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        boolean ans = isInterleave(s1, s2, s3);

        System.out.println(ans);
    }
}
