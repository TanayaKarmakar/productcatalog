package com.app.educative.io.dp.palindromicsubsequence;

public class PalindromicPartition {
    private static void findMinCuts(String str) {
        int ans = findMPPRec(str, 0, str.length() - 1);
        System.out.println("Minimum Palindromic Cuts Recursion: " + ans);

        Integer[][] dp = new Integer[str.length()][str.length()];
        ans = findMPPTopDown(str, 0, str.length() - 1, dp);
        System.out.println("Minimum Palindromic Cuts Top Down: " + ans);
    }

    private static int findMPPTopDown(String str, int start, int end, Integer[][] dp) {
        if(start >= end || isPalindrome(str, start, end))
            return 0;
        if(dp[start][end] != null)
            return dp[start][end];
        int minimumCuts = end - start;
        for(int i = start; i <= end; i++) {
            if(isPalindrome(str, start, i)) {
                minimumCuts = Integer.min(minimumCuts, 1 + findMPPTopDown(str, i + 1, end, dp));
            }
        }
        dp[start][end] = minimumCuts;
        return dp[start][end];
    }

    private static int findMPPRec(String str, int start, int end) {
        if(start >= end || isPalindrome(str, start, end))
            return 0;
        int minCuts = end - start;
        for(int i = start; i <= end; i++) {
            if(isPalindrome(str, start, i)) {
                minCuts = Integer.min(minCuts, 1 + findMPPRec(str, i + 1, end));
            }
        }
        return minCuts;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        findMinCuts("abdca");
    }
}
