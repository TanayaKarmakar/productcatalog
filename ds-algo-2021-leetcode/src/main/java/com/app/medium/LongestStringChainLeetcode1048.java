package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
public class LongestStringChainLeetcode1048 {
    private static int longestStrChain(String[] words) {
        Arrays.sort(words, (i1, i2) -> i1.length() - i2.length());
        int n = words.length;
        int[] dp = new int[n];
        //dp[n - 1] = 1;

        Arrays.fill(dp, 1);

        int maxValue = 1;
        for(int i = n - 1; i >= 0; i--) {
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                String newWord = word.substring(0, j) + word.substring(j + 1);
                int k = i;
                while(k >= 0 && newWord.length() != words[k].length()) {
                    k--;
                }
                while(k >= 0 && words[k].length() <= newWord.length()) {
                    if(words[k].equals(newWord)) {
                        dp[k] = Integer.max(dp[k], 1 + dp[i]);
                        maxValue = Integer.max(maxValue, dp[k]);
                    }
                    k--;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return maxValue;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        int ans = longestStrChain(words);

        System.out.println(ans);
    }
}
