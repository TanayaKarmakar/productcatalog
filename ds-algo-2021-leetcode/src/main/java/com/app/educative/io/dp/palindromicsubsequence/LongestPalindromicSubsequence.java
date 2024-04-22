package com.app.educative.io.dp.palindromicsubsequence;

public class LongestPalindromicSubsequence {
    private static void lps(String str) {
        int ans = lpsRecursion(str, 0, str.length() - 1);
        System.out.println("Answer of recursion: " + ans);

        Integer[][] dp = new Integer[str.length()][str.length()];
        ans = lpsTopDown(str, 0, str.length() - 1, dp);
        System.out.println("Answer of memoization: " + ans);

        ans = lpsBottomUp(str);
        System.out.println("Answer of tabulation: " + ans);
    }

    private static int lpsBottomUp(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for(int startIndx = n - 2; startIndx >= 0; startIndx--) {
            for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
                if(str.charAt(startIndx) == str.charAt(endIndx)) {
                    dp[startIndx][endIndx] = 2 + dp[startIndx + 1][endIndx - 1];
                } else {
                    dp[startIndx][endIndx] = Integer.max(dp[startIndx + 1][endIndx], dp[startIndx][endIndx - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    private static int lpsTopDown(String str, int start, int end, Integer[][] dp) {
        if(start > end)
            return 0;
        if(start == end)
            return 1;
        if(dp[start][end] != null)
            return dp[start][end];
        int ans = 0;
        if(str.charAt(start) == str.charAt(end))
            ans = 2 + lpsTopDown(str, start + 1, end - 1, dp);
        else
            ans = Integer.max(lpsTopDown(str, start + 1, end, dp), lpsTopDown(str, start, end - 1, dp));
        dp[start][end] = ans;
        return dp[start][end];
    }

    private static int lpsRecursion(String str, int start, int end) {
        if(start > end)
            return 0;
        if(start == end)
            return 1;
        if(str.charAt(start) == str.charAt(end))
            return 2 + lpsRecursion(str, start + 1, end - 1);
        else
            return Integer.max(lpsRecursion(str, start + 1, end), lpsRecursion(str, start, end - 1));
    }


    public static void main(String[] args) {
        lps("abdbca");
    }
}
