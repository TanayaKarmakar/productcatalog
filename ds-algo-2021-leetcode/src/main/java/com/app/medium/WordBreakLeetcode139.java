package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 30/03/22
 * @project ds-algo-2021
 */
public class WordBreakLeetcode139 {
    private static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                String currentWord = s.substring(j, i + 1);
                if(wordDict.contains(currentWord)) {
                    if(j > 0) {
                        dp[i] += dp[j - 1];
                    } else {
                        dp[i]++;
                    }
                }
            }
        }
        return dp[n - 1] > 0;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        boolean ans = wordBreak(s, wordDict);

        System.out.println(ans);

        s = "catsandog";
        wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        ans = wordBreak(s, wordDict);

        System.out.println(ans);
    }
}
