package com.app.medium;

import java.util.Arrays;

public class LongestStringChainLeetcode1048 {
    private static int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLenChain = 1;
        dp[n - 1] = 1;
        for(int i = n - 1; i > 0; i--) {

            for(int j = i - 1; j >= 0; j--) {
                if(words[i].length() == words[j].length())
                    continue;
                if(words[i].length() > words[j].length() + 1)
                    break;
                if(isPredecessor(words[j], words[i])) {
                    dp[j] = Integer.max(dp[j], 1 + dp[i]);
                }

            }
        }

        for(int i = 0; i < dp.length; i++) {
            maxLenChain = Integer.max(maxLenChain, dp[i]);
        }
        return maxLenChain;
    }

    private static boolean isPredecessor(String substring, String str) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < substring.length() && j < str.length()) {
            if(substring.charAt(i) != str.charAt(j)) {
                if(count == 1)
                    return false;
                count++;
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
    }
}
